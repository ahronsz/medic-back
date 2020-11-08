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
            citas = this.listarCitasXDia(especialidadMedico); // lista cita por mir
        }
        especialidadMedico.setHora(this.mostrarHorasDisponibles(citas));
        if (!StringUtils.isBlank(especialidadMedico.getCod_med())) {
            System.out.println("entra a filtrar");
            this.filtrarHorasXDisponibilidad(especialidadMedico);
        }
        this.agregarMeridiano(especialidadMedico);
        return especialidadMedico;
    }

    private Hora mostrarHorasDisponibles(List<Cita> citas) {
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

        for (Cita c : citas) horas.remove(c.getHora());

        hora.setHoras(horas);
        return hora;
    }

    private void filtrarHorasXDisponibilidad(EspecialidadMedico em) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("H:mm");
        String cod_mir = repositorioCita.buscarMedicoEspecialidad(em.getCod_med(), em.getCod_esp());
        String hora_start = (repositorioCita.obtenerHoraStartXMIR(cod_mir).split(":"))[0];
        String hora_end = (repositorioCita.obtenerHoraEndXMIR(cod_mir).split(":"))[0];

        List<String> horas = new ArrayList<String>();

        for (int i = Integer.parseInt(hora_start); i <= Integer.parseInt(hora_end); i++) {
            horas.add(format.format(LocalTime.of(i, 0)));
        }
        em.getHora().getHoras().retainAll(horas);
    }

    private void agregarMeridiano(EspecialidadMedico em) {
        DateTimeFormatter format_m = DateTimeFormatter.ofPattern("hh:mm a");
        List<String> hora_m = new ArrayList<String>();
        em.getHora().getHoras().forEach((h) -> {
            hora_m.add(format_m.format(LocalTime.parse(h)));
        });
        em.getHora().setHoras_m(hora_m);
    }
}
