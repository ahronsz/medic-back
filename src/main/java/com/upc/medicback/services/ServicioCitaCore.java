package com.upc.medicback.services;

import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.EspecialidadMedico;

import java.util.List;

public interface ServicioCitaCore {
    public List<Cita> listarCitasXDia(EspecialidadMedico especialidadMedico);
    public EspecialidadMedico listarHorasDisponibleXDia(EspecialidadMedico especialidadMedico);
}
