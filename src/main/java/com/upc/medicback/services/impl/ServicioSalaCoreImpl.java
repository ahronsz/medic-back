package com.upc.medicback.services.impl;

import com.upc.medicback.dao.ServicioSalaDAO;
import com.upc.medicback.entidades.Sala;
import com.upc.medicback.repositorio.RepositorioSala;
import com.upc.medicback.services.ServicioSalaCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioSalaCoreImpl implements ServicioSalaCore {

    @Autowired
    private RepositorioSala repositorioSala;

    @Autowired
    private ServicioSalaDAO servicioSalaDAO;

    @Override
    public Sala obtenerSalaRandom() {
        Sala sala = repositorioSala.obtenerSalaRandom();
        sala.setEstado("1");
        return servicioSalaDAO.editarSala(sala);
    }
}
