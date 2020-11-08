package com.upc.medicback.services;

import com.upc.medicback.entidades.Especialidad;

import java.util.List;

public interface ServicioEspecialidadCore {
    public List<Especialidad> listarEspecialidades();

    public List<Especialidad> listarEspecialidadesXMedico();
}
