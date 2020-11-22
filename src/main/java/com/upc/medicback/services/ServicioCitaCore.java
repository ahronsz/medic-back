package com.upc.medicback.services;

import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.EspecialidadMedico;

import java.util.List;

public interface ServicioCitaCore {
    List<Cita.Detail> obtenerCitas();
    List<Cita> listarCitasXDia(EspecialidadMedico especialidadMedico);
    List<Cita> listarCitasXDiaEspecialidad(EspecialidadMedico especialidadMedico);
    EspecialidadMedico listarHorasDisponibleXDia(EspecialidadMedico especialidadMedico);
    Cita.Detail registrarCita(Cita cita);
    Cita.Detail obtenerDetalleCita(Cita cita);
}
