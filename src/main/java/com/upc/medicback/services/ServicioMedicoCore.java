package com.upc.medicback.services;

import com.upc.medicback.entidades.Medico;

import java.util.List;

public interface ServicioMedicoCore {
    List<Medico> listarMedicos();
    List<Medico> listarMedicosXEspecialidad(String cod_esp);
    Medico obtenerMedicoXMir(String cod_mir);
}
