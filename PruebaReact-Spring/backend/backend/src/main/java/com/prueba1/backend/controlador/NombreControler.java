package com.prueba1.backend.controlador;

import com.prueba1.backend.modelo.Nombre;
import com.prueba1.backend.service.NombreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nombre")
@CrossOrigin
public class NombreControler {

    @Autowired
    private NombreService nomServi;

    @PostMapping("/add")
    public String add(@RequestBody Nombre nombre) {
        nomServi.saveNombre(nombre);
        return "New student is added";
    }

    @GetMapping("/getAll")
    public List<Nombre> getAllNombres(){
        return nomServi.getAllNombres();
    }
}
