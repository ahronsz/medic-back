package com.upc.medicback.dao.impl;

import com.upc.medicback.dao.ServicioCitaDAO;
import com.upc.medicback.entidades.Cita;
import com.upc.medicback.repositorio.RepositorioCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCitaDAOImpl implements ServicioCitaDAO {

    @Autowired
    private RepositorioCita repositorioCita;

    @Override
    public List<Cita> obtenerCitas() {
        return (List<Cita>) repositorioCita.findAll();
    }
}
