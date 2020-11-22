package com.upc.medicback.services;

import com.upc.medicback.entidades.Especialidad;

import java.util.List;

public interface ServicioEspecialidadCore {
    List<Especialidad> listarEspecialidades();
    Especialidad obtenerEspecialidadXMir(String cod_mir);
}
