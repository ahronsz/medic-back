package com.upc.medicback.rest;

import com.upc.medicback.entidades.Medico;
import com.upc.medicback.services.ServicioMedicoCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medico")
public class MedicoCoreRestImpl implements MedicoCoreRest {

    @Autowired
    private ServicioMedicoCore servicioMedicoCore;

    @GetMapping("/listar")
    public List<Medico> listarMedicos() {
        return servicioMedicoCore.listarMedicos();
    }

    @GetMapping("/especialidad/{cod_esp}")
    public List<Medico> listarMedicosXEspecialidad (@PathVariable("cod_esp") String cod_esp) {
        return servicioMedicoCore.listarMedicosXEspecialidad(cod_esp);
    }
}
