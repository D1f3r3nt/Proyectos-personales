package com.prueba1.backend.repositorio;

import com.prueba1.backend.modelo.Nombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NombreRepositorio extends JpaRepository<Nombre, Integer> {
}
