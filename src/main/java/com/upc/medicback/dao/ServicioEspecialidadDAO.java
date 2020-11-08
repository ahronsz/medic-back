package com.upc.medicback.dao;

import com.upc.medicback.entidades.Especialidad;

import java.util.List;

public interface ServicioEspecialidadDAO {
    public Especialidad registrarEspecialidad(Especialidad especialidad);

    public Especialidad obtenerEspecialidad(String cod_esp);

    public List<Especialidad> listarEspecialidades();

    public Especialidad actualizarEspecialidad(Especialidad especialidad);
}
