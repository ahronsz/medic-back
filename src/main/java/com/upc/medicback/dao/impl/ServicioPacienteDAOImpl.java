package com.upc.medicback.dao.impl;

import com.upc.medicback.dao.ServicioPacienteDAO;
import com.upc.medicback.entidades.Paciente;
import com.upc.medicback.repositorio.RepositorioPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPacienteDAOImpl implements ServicioPacienteDAO {

    @Autowired
    private RepositorioPaciente repositorioPaciente;

    @Override
    public Paciente obtenerPaciente(String cod_pac) {
        return repositorioPaciente.findById(cod_pac).get();
    }
}
