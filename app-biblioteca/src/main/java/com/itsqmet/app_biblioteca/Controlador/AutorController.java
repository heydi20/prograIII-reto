package com.itsqmet.app_biblioteca.Controlador;

import com.itsqmet.app_biblioteca.Entidad.Autor;
import com.itsqmet.app_biblioteca.Servicio.AutorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AutorController {
    @Autowired
    AutorServicio autorServicio;

    //Leer
    @GetMapping("/autores")
    public String listarAutores(@RequestParam(name = "buscarAutor", required = false,defaultValue = "")String buscarAutor, Model model){
        List<Autor> autores =autorServicio.buscarAutorNombre(buscarAutor);
        model.addAttribute("buscarAutor", buscarAutor);
        model.addAttribute("autores", autores);
        return "Autor/listarAutor";

    }

    //Listar autor
    @GetMapping("/formularioAutor")
    public String mostrarFormulario(Model model){
        model.addAttribute("autor", new Autor());
        return "Autor/formulario";
    }


    @PostMapping("/registrar")
    public String insertarAutor(Autor autor){
        autorServicio.guardarAutor(autor);
        return "redirect:/autores";
    }

    //Actualizar
    @GetMapping("/actualizar/{id}")
    public String editarAuto(@PathVariable Long id, Model model){
        Optional<Autor> autor=autorServicio.buscarAutorId(id);
        model.addAttribute("autor",autor);
        return "Autor/formulario";

    }

    //Eliminar
    @GetMapping("/eliminarAutor/{id}")
    public String eliminarAutor(@PathVariable Long id){
        autorServicio.eliminarAutor(id);
        return "redirect:/autores";
    }


}
