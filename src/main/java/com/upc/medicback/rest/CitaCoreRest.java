package com.upc.medicback.rest;

import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.EspecialidadMedico;

import java.util.List;

public interface CitaCoreRest {
    public List<Cita> listarCitaXDia(EspecialidadMedico especialidadMedico);

    public List<Cita> listarCitasXDiaEspecialidad(EspecialidadMedico especialidadMedico);

    public EspecialidadMedico listarHorasDisponibleXDia(EspecialidadMedico especialidadMedico);

    public Cita registrarCita(Cita cita);
}
