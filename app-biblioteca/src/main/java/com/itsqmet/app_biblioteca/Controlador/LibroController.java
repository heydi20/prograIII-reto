package com.itsqmet.app_biblioteca.Controlador;


import com.itsqmet.app_biblioteca.Entidad.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


import java.util.List;

@Controller
public class LibroController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/libros")
    public String mostrarLibros(Model model){
        List<Libro> libros = restTemplate.getForObject("http://localhost:8080/api/libros", List.class);
        model.addAttribute("libros", libros);
        return "Libro/datosLibros";
    }

}
