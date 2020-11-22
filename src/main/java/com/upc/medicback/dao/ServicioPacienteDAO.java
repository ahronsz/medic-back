package com.upc.medicback.dao;

import com.upc.medicback.entidades.Paciente;

public interface ServicioPacienteDAO {
    public Paciente obtenerPaciente(String cod_pac);
}
