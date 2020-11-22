package com.upc.medicback.dao.impl;

import com.upc.medicback.dao.ServicioMedicoDAO;
import com.upc.medicback.entidades.Medico;
import com.upc.medicback.repositorio.RepositorioMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioMedicoDAOImpl implements ServicioMedicoDAO {

    @Autowired
    private RepositorioMedico repositorioMedico;

    @Override
    public Medico getMedico(String cod_med) {
        return repositorioMedico.findById(cod_med).get();
    }
}
