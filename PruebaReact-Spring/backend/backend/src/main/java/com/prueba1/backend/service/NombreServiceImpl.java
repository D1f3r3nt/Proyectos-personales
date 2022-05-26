package com.prueba1.backend.service;

import com.prueba1.backend.modelo.Nombre;
import com.prueba1.backend.repositorio.NombreRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NombreServiceImpl implements NombreService{

    @Autowired
    private NombreRepositorio nombreRepositorio;

    @Override
    public Nombre saveNombre(Nombre nombre) {
        return nombreRepositorio.save(nombre);
    }

    @Override
    public List<Nombre> getAllNombres() {
        return nombreRepositorio.findAll();
    }
}
