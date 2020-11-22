package com.upc.medicback.rest;

import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.EspecialidadMedico;

import java.util.List;

public interface CitaCoreRest {
    List<Cita.Detail> obtenerCitas();
    List<Cita> listarCitaXDia(EspecialidadMedico especialidadMedico);
    List<Cita> listarCitasXDiaEspecialidad(EspecialidadMedico especialidadMedico);
    EspecialidadMedico listarHorasDisponibleXDia(EspecialidadMedico especialidadMedico);
    Cita.Detail registrarCita(Cita cita);
    Cita.Detail detalleCita(Cita cita);
}
