package com.upc.medicback.services;

//import com.upc.medicback.dao.ServicioEspecialidadDAO;
import com.upc.medicback.entidades.Especialidad;
import com.upc.medicback.repositorio.RepositorioEspecialidad;
import com.upc.medicback.util.Utilitario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioEspecialidadCoreImpl implements ServicioEspecialidadCore {
    @Autowired
    private Utilitario utilitario;
//    @Autowired
//    private ServicioEspecialidadDAO servicioEspecialidadDAO;
    @Autowired
    private RepositorioEspecialidad repositorioEspecialidad;

    @Override
    public List<Especialidad> listarEspecialidades() {
        return (List<Especialidad>) repositorioEspecialidad.findAll();
    }

    @Override
    public List<Especialidad> listarEspecialidadesXMedico() {
        return null;
    }
}
