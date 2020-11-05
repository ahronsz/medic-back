package com.upc.medicback.services;

import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.EspecialidadMedico;
import com.upc.medicback.repositorio.RepositorioCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioCitaCoreImpl implements ServicioCitaCore {

    @Autowired
    private RepositorioCita repositorioCita;

    @Override
    public List<Cita> listarCitasXDia(EspecialidadMedico especialidadMedico) {
        DateTimeFormatter formmat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String cod_mir = repositorioCita.buscarMedicoEspecialidad(especialidadMedico.getCod_med(), especialidadMedico.getCod_esp());
        return repositorioCita.listarCitasXDia(cod_mir, formmat.format(especialidadMedico.getFecha()));
    }

    @Override
    public EspecialidadMedico listarHorasDisponibleXDia(EspecialidadMedico especialidadMedico) {
        List<Cita> citas = listarCitasXDia(especialidadMedico);
        List<String> hora = new ArrayList<String>();
        hora.add("09:00");
        hora.add("10:00");
        hora.add("11:00");
        hora.add("12:00");
        hora.add("13:00");
        hora.add("14:00");
        hora.add("15:00");
        hora.add("16:00");
        hora.add("17:00");
        hora.add("18:00");

        for (Cita c: citas) hora.remove(c.getHora());
        especialidadMedico.getHoras().addAll(hora);
        return especialidadMedico;
    }
}
