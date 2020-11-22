package com.upc.medicback.services.impl;

//import com.upc.medicback.dao.ServicioEspecialidadDAO;

import com.upc.medicback.entidades.Especialidad;
import com.upc.medicback.repositorio.RepositorioEspecialidad;
import com.upc.medicback.services.ServicioEspecialidadCore;
import com.upc.medicback.util.Utilitario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioEspecialidadCoreImpl implements ServicioEspecialidadCore {

    @Autowired
    private Utilitario utilitario;

    @Autowired
    private RepositorioEspecialidad repositorioEspecialidad;

    @Override
    public List<Especialidad> listarEspecialidades() {
        return (List<Especialidad>) repositorioEspecialidad.findAll();
    }

    @Override
    public Especialidad obtenerEspecialidadXMir(String cod_mir) {
        return repositorioEspecialidad.obtenerEspecialidadXMir(cod_mir);
    }

}
