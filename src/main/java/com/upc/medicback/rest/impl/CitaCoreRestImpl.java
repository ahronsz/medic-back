package com.upc.medicback.rest.impl;

import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.EspecialidadMedico;
import com.upc.medicback.rest.CitaCoreRest;
import com.upc.medicback.services.ServicioCitaCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/api/cita")
public class CitaCoreRestImpl implements CitaCoreRest {

    @Autowired
    private ServicioCitaCore servicioCitaCore;

    @GetMapping("/all")
    public List<Cita.Detail> obtenerCitas() {
        List<Cita.Detail> c = null;
        try {
            c = servicioCitaCore.obtenerCitas();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puedo listar las citas, revise su request");
        }
        return c;
    }

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

    @PostMapping("/disponible")
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
    public Cita.Detail registrarCita(@RequestBody Cita cita) {
        Cita.Detail c = null;
        try {
            c = servicioCitaCore.registrarCita(cita);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo crear, revise su request");
        }
        return c;
    }

    @PostMapping("/detalle")
    public Cita.Detail detalleCita(@RequestBody Cita cita) {
        Cita.Detail c = null;
        try {
            c = servicioCitaCore.obtenerDetalleCita(cita);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo detallar la cita, revise su request");
        }
        return c;
    }
}
