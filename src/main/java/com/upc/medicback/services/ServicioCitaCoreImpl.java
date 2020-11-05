package com.upc.medicback.services;

import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.EspecialidadMedico;
import com.upc.medicback.repositorio.RepositorioCita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioCitaCoreImpl implements ServicioCitaCore {

    @Autowired
    private RepositorioCita repositorioCita;

    @Override
    public Cita registrarCita(Cita cita) {
        cita.setCod_cit(repositorioCita.obtenerCodigo());
        return repositorioCita.save(cita);
    }

    @Override
    public List<Cita> listarCitasXDia(EspecialidadMedico especialidadMedico) {// Lista cita por dia,medico y especialida
        DateTimeFormatter formmat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String cod_mir = repositorioCita.buscarMedicoEspecialidad(especialidadMedico.getCod_med(), especialidadMedico.getCod_esp());
        return repositorioCita.listarCitasXDia(cod_mir, formmat.format(especialidadMedico.getFecha()));
    }

    @Override
    public List<Cita> listarCitasXDiaEspecialidad(EspecialidadMedico especialidadMedico) { // Lista cita por dia y especialida
        DateTimeFormatter formmat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return repositorioCita.listarCitasXDiaEspecialidad(especialidadMedico.getCod_esp(), formmat.format(especialidadMedico.getFecha()));
    }

    @Override
    public EspecialidadMedico listarHorasDisponibleXDia(EspecialidadMedico especialidadMedico) {  //Muestra los horarios disponibles
        List<Cita> citas = new ArrayList<Cita>();
        if (especialidadMedico.getCod_med().equals("")) {
            citas = this.listarCitasXDiaEspecialidad(especialidadMedico);
        } else {
            citas = this.listarCitasXDia(especialidadMedico);
        }
        especialidadMedico.getHoras().addAll(this.mostrarDiasDisponibles(citas));
        return especialidadMedico;
    }

    private List<String> mostrarDiasDisponibles (List<Cita> citas) {
        List<String> horas = new ArrayList<String>();
        List<String> horasDisponible = new ArrayList<String>();
        horas.add("09:00");
        horas.add("10:00");
        horas.add("11:00");
        horas.add("12:00");
        horas.add("13:00");
        horas.add("14:00");
        horas.add("15:00");
        horas.add("16:00");
        horas.add("17:00");
        horas.add("18:00");

        for (Cita c: citas) horas.remove(c.getHora());
        horasDisponible.addAll(horas);
        return horasDisponible;
    }


}
