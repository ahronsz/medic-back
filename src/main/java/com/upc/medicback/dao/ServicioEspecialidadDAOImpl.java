//package com.upc.medicback.dao;
//
//import com.upc.medicback.entidades.Especialidad;
//import com.upc.medicback.repositorio.RepositorioEspecialidad;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ServicioEspecialidadDAOImpl implements ServicioEspecialidadDAO {
//
//    @Autowired
//    private RepositorioEspecialidad repositorioEspecialidad;
//
//    @Override
//    public Especialidad registrarEspecialidad(Especialidad especialidad) {
//        return repositorioEspecialidad.save(especialidad); // entidad administrador
//    }
//
//    @Override
//    public Especialidad obtenerEspecialidad(String cod_esp) {
//        return repositorioEspecialidad.findById(cod_esp).get();
//    }
//
//    @Override
//    public List<Especialidad> listarEspecialidades() {
//        return (List<Especialidad>) repositorioEspecialidad.findAll();
//    }
//
//    @Override
//    public Especialidad actualizarEspecialidad(Especialidad especialidad) {
//        return null; // entidad administrador
//    }
//}
