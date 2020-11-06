package com.upc.medicback.services;

import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.EspecialidadMedico;
import com.upc.medicback.entidades.EspecialidadMedico.Hora;
import com.upc.medicback.repositorio.RepositorioCita;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
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
        cita.setEstado('0');
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
        List<Cita> citas;
        if (StringUtils.isBlank(especialidadMedico.getCod_med())) {
            citas = this.listarCitasXDiaEspecialidad(especialidadMedico);
            especialidadMedico.setCod_med("");
        } else {
            citas = this.listarCitasXDia(especialidadMedico);
        }
        especialidadMedico.setHora(this.mostrarHorasDisponibles(citas));
        return especialidadMedico;
    }

    private Hora mostrarHorasDisponibles (List<Cita> citas) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm a");
        Hora hora = new Hora();
        List<String> horas = new ArrayList<String>();
        List<String> horas_m = new ArrayList<String>();

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
        horas.forEach( (h) -> horas_m.add(format.format(LocalTime.parse(h))));

        hora.setHoras(horas);
        hora.setHoras_m(horas_m);
        return hora;
    }
}
