package com.itsqmet.app_biblioteca.Servicio;

import com.itsqmet.app_biblioteca.Entidad.Autor;
import com.itsqmet.app_biblioteca.Repositorio.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServicio {
    @Autowired
    AutorRepositorio autorRepositorio;

    public List<Autor> mostrarAutores(){
        return autorRepositorio.findAll();
    }

    public Optional<Autor> buscarAutorId(Long id){
        return autorRepositorio.findById(id);
    }
    public List<Autor> buscarAutorNombre(String buscarAutor){
        if(buscarAutor==null || buscarAutor.isEmpty()){
            return autorRepositorio.findAll();
        }else{
            return autorRepositorio.findByNombreContainingIgnoreCase(buscarAutor);
        }
    }

    public void guardarAutor(Autor autor){
        autorRepositorio.save(autor);
    }

    public void eliminarAutor(Long id){
        autorRepositorio.deleteById(id);
    }
}
