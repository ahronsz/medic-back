package com.upc.medicback.dao.impl;

import com.upc.medicback.dao.ServicioSalaDAO;
import com.upc.medicback.entidades.Sala;
import com.upc.medicback.repositorio.RepositorioSala;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioSalaDAOImpl implements ServicioSalaDAO {

    @Autowired
    private RepositorioSala repositorioSala;

    @Override
    public Sala obtenerSala(String cod_sal) {
        return repositorioSala.findById(cod_sal).get();
    }

    @Override
    public Sala editarSala(Sala sala) {
        return repositorioSala.save(sala);
    }
}
