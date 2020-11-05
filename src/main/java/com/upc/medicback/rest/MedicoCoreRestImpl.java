package com.upc.medicback.rest;

import com.upc.medicback.entidades.Medico;
import com.upc.medicback.services.ServicioMedicoCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/medico")
public class MedicoCoreRestImpl implements MedicoCoreRest {

    @Autowired
    private ServicioMedicoCore servicioMedicoCore;

    @GetMapping("/listar")
    public List<Medico> listarMedicos() {
        List<Medico> m = null;
        try {
            m = servicioMedicoCore.listarMedicos();
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puedo buscar, revise su request");
        }
        return m;
    }

    @GetMapping("/especialidad/{cod_esp}")
    public List<Medico> listarMedicosXEspecialidad (@PathVariable("cod_esp") String cod_esp) {
        List<Medico> m = null;
        try {
            m = servicioMedicoCore.listarMedicosXEspecialidad(cod_esp);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puedo buscar, revise su request");
        }
        return m;
    }
}
