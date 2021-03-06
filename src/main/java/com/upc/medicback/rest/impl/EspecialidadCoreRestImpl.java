package com.upc.medicback.rest.impl;

import com.upc.medicback.entidades.Especialidad;
import com.upc.medicback.rest.EspecialidadCoreRest;
import com.upc.medicback.services.ServicioEspecialidadCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/especialidad")
public class EspecialidadCoreRestImpl implements EspecialidadCoreRest {
    @Autowired
    private ServicioEspecialidadCore servicioEspecialidadCore;

    @GetMapping("/listar")
    public List<Especialidad> listarEspecialidad() {
        List<Especialidad> esp = null;
        try {
            esp = servicioEspecialidadCore.listarEspecialidades();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puedo buscar, revise su request");
        }
        return esp;
    }
}
