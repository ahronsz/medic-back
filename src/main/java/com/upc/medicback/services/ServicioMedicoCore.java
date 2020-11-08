package com.upc.medicback.services;

import com.upc.medicback.entidades.Medico;

import java.util.List;

public interface ServicioMedicoCore {
    public List<Medico> listarMedicos();

    public List<Medico> listarMedicosXEspecialidad(String cod_esp);
}
