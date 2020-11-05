package com.upc.medicback.rest;

import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.EspecialidadMedico;
import com.upc.medicback.services.ServicioCitaCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cita")
public class CitaCoreRestImpl implements CitaCoreRest {

    @Autowired
    private ServicioCitaCore servicioCitaCore;

    @GetMapping("/dia")
    public List<Cita> listarCitaXDia(@RequestBody EspecialidadMedico especialidadMedico) {
        return servicioCitaCore.listarCitasXDia(especialidadMedico);
    }

    @GetMapping("/disponible")
    public EspecialidadMedico listarHorasDisponibleXDia(@RequestBody EspecialidadMedico especialidadMedico) {
        return servicioCitaCore.listarHorasDisponibleXDia(especialidadMedico);
    }
}
