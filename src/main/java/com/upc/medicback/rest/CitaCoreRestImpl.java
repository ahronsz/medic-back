package com.upc.medicback.rest;

import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.EspecialidadMedico;
import com.upc.medicback.services.ServicioCitaCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/cita")
public class CitaCoreRestImpl implements CitaCoreRest {

    @Autowired
    private ServicioCitaCore servicioCitaCore;

    @GetMapping("/dia")
    public List<Cita> listarCitaXDia(@RequestBody EspecialidadMedico especialidadMedico) {
        List<Cita> c = null;
        try {
            c = servicioCitaCore.listarCitasXDia(especialidadMedico);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puedo buscar, revise su request");
        }
        return c;
    }

    @GetMapping("/especialidad")
    public List<Cita> listarCitasXDiaEspecialidad(@RequestBody EspecialidadMedico especialidadMedico) {
        List<Cita> c = null;
        try {
            c = servicioCitaCore.listarCitasXDiaEspecialidad(especialidadMedico);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puedo buscar, revise su request");
        }
        return c;
    }

    @GetMapping("/disponible")
    public EspecialidadMedico listarHorasDisponibleXDia(@RequestBody EspecialidadMedico especialidadMedico) {
        EspecialidadMedico em = null;
        try {
            em = servicioCitaCore.listarHorasDisponibleXDia(especialidadMedico);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puedo buscar, revise su request");
        }
        return em;
    }

    @PostMapping("/save")
    public Cita registrarCita(@RequestBody Cita cita) {
        Cita c = null;
        try {
            c = servicioCitaCore.registrarCita(cita);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo crear, revise su request");
        }
        return c;
    }
}
