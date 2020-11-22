package com.upc.medicback.services.impl;

import com.upc.medicback.entidades.Medico;
import com.upc.medicback.repositorio.RepositorioMedico;
import com.upc.medicback.services.ServicioMedicoCore;
import com.upc.medicback.util.Utilitario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioMedicoCoreImpl implements ServicioMedicoCore {

    @Autowired
    private Utilitario utilitario;

    @Autowired
    private RepositorioMedico repositorioMedico;

    @Override
    public List<Medico> listarMedicos() {
        List<Medico> medicos = (List<Medico>) repositorioMedico.findAll();
        for (Medico m : medicos) {
            m.setEdad(utilitario.obtenerEdad(m.getFechaNaci()));
        }
        return medicos;
    }

    @Override
    public List<Medico> listarMedicosXEspecialidad(String cod_esp) {
        List<Medico> medicos = repositorioMedico.listarMedicoXEspecialidad(cod_esp);
        for (Medico m : medicos) {
            m.setEdad(utilitario.obtenerEdad(m.getFechaNaci()));
        }
        return medicos;
    }

    @Override
    public Medico obtenerMedicoXMir(String cod_mir) {
        return repositorioMedico.obtenerMedicoXMir(cod_mir);
    }
}
