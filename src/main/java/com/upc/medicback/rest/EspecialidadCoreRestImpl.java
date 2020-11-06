package com.upc.medicback.rest;

import com.upc.medicback.entidades.Especialidad;
import com.upc.medicback.services.ServicioEspecialidadCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/especialidad")
public class EspecialidadCoreRestImpl implements EspecialidadCoreRest {
    @Autowired
    private ServicioEspecialidadCore servicioEspecialidadCore;

    @GetMapping("/listar")
    public List<Especialidad> listarEspecialidad() {
        List<Especialidad> esp = null;
        try {
            esp = servicioEspecialidadCore.listarEspecialidades();
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puedo buscar, revise su request");
        }
        return esp;
    }
}
