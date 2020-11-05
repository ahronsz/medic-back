package com.upc.medicback.rest;

import com.upc.medicback.entidades.Especialidad;
import com.upc.medicback.services.ServicioEspecialidadCore;
import com.upc.medicback.services.ServicioMedicoCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/especialidad")
public class EspecialidadCoreRestImpl implements EspecialidadCoreRest {
    @Autowired
    private ServicioEspecialidadCore servicioEspecialidadCore;

    @GetMapping("/listar")
    public List<Especialidad> listarEspecialidad() {
        return servicioEspecialidadCore.listarEspecialidades();
    }
}
