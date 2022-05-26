package com.prueba1.backend.service;

import com.prueba1.backend.modelo.Nombre;

import java.util.List;

public interface NombreService {
    public Nombre saveNombre(Nombre nombre);
    public List<Nombre> getAllNombres();
}
