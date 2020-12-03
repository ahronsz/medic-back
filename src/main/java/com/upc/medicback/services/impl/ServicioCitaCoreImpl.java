package com.upc.medicback.services.impl;

import com.upc.medicback.dao.*;
import com.upc.medicback.entidades.*;
import com.upc.medicback.entidades.EspecialidadMedico.Hora;
import com.upc.medicback.repositorio.RepositorioCita;
import com.upc.medicback.services.ServicioCitaCore;
import com.upc.medicback.services.ServicioEspecialidadCore;
import com.upc.medicback.services.ServicioMedicoCore;
import com.upc.medicback.services.ServicioSalaCore;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioCitaCoreImpl implements ServicioCitaCore {

    @Autowired
    private RepositorioCita repositorioCita;

    @Autowired
    private ServicioMedicoCore servicioMedicoCore;

    @Autowired
    private ServicioEspecialidadCore servicioEspecialidadCore;

    @Autowired
    private ServicioPacienteDAO servicioPacienteDAO;

    @Autowired
    private ServicioSalaCore servicioSalaCore;

    @Autowired
    private ServicioSalaDAO servicioSalaDAO;

    @Autowired
    private ServicioCitaDAO servicioCitaDAO;

    @Override
    public Cita.Detail registrarCita(Cita cita) {
        cita.setCod_cit(repositorioCita.obtenerCodigo());
        this.obtenerDetalleCita(cita);
        repositorioCita.save(cita);
        return cita.getDetail();
    }

    @Override
    public String registrarColaCita(CitaOyente citaCola) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(citaCola.getFecha(), formatter);

        Cita cita = new Cita();
        cita.setCod_pac(citaCola.getCod_pac());
        cita.setCod_med(citaCola.getCod_med());
        cita.setCod_esp(citaCola.getCod_esp());
        cita.setFecha(localDate);
        cita.setHora(citaCola.getHora());
        this.registrarCita(cita);
        try {
            return "Registrado";
        } catch (Exception e) {
            return "Error " + e;
        }
    }

    @Override
    public List<Cita.Detail> obtenerCitas() {
        List<Cita> citas = servicioCitaDAO.obtenerCitas();
        List<Cita.Detail> citaDetalle = new ArrayList<>();
        citas.forEach( (cita) -> citaDetalle.add(this.obtenerDetalleCita(cita)));
        return citaDetalle;
    }

    @Override
    public Cita.Detail obtenerDetalleCita(Cita cita){
        Sala sala = this.servicioSalaCore.obtenerSalaRandom();

        cita.setEstado(StringUtils.isBlank(cita.getEstado()) ? "0" : cita.getEstado());
        cita.setCod_mir(StringUtils.isBlank(cita.getCod_mir()) ? repositorioCita.buscarMedicoEspecialidad(cita.getCod_med(), cita.getCod_esp()) : cita.getCod_mir());
        cita.setCod_sal(StringUtils.isBlank(cita.getCod_sal()) ? sala.getCod_sal() : cita.getCod_sal());
        cita.setDetail(this.mapCita(cita));

        sala.setEstado("2");
        servicioSalaDAO.editarSala(sala);
        return cita.getDetail();
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
            this.filtrarHorasXDisponibilidad(especialidadMedico);
        }
        this.agregarMeridiano(especialidadMedico);
        return especialidadMedico;
    }

    private Hora mostrarHorasDisponibles(List<Cita> citas) { // pendiente listar horarios con horas disponibles de medico
        Hora hora = new Hora();
        List<String> horas = new ArrayList<>();

        horas.add("09:00");
        horas.add("10:00");
        horas.add("11:00");
        horas.add("12:00");
        horas.add("15:00");
        horas.add("16:00");
        horas.add("17:00");
        horas.add("18:00");

        for (Cita c : citas) horas.remove(c.getHora());

        hora.setHoras(horas);
        return hora;
    }

    private void filtrarHorasXDisponibilidad(EspecialidadMedico em) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        String cod_mir = repositorioCita.buscarMedicoEspecialidad(em.getCod_med(), em.getCod_esp());
        int hora_start = Integer.parseInt((repositorioCita.obtenerHoraStartXMIR(cod_mir).split(":"))[0]);
        int hora_end = Integer.parseInt((repositorioCita.obtenerHoraEndXMIR(cod_mir).split(":"))[0]);

        List<String> horas = new ArrayList<>();

        for (int i = hora_start; i <= hora_end; i++) {
            horas.add(format.format(LocalTime.of(i, 0)));
        }
        em.getHora().getHoras().retainAll(horas);
    }

    private void agregarMeridiano(EspecialidadMedico em) {
        DateTimeFormatter format_m = DateTimeFormatter.ofPattern("hh:mm a");
        List<String> hora_m = new ArrayList<>();
        em.getHora().getHoras().forEach((h) -> hora_m.add(format_m.format(LocalTime.parse(h))));
        em.getHora().setHoras_m(hora_m);
    }

    private Cita.Detail mapCita(Cita cita) {
        DateTimeFormatter format_m = DateTimeFormatter.ofPattern("hh:mm a");
        String[] abc = {"A-10", "B-20", "C-30", "D-40", "E-50", "F-60"};
        String[] estado = {"Vigente", "Atendido", "Vencido", "Cancelado"};

        Medico medico = servicioMedicoCore.obtenerMedicoXMir(cita.getCod_mir());
        Especialidad especialidad = servicioEspecialidadCore.obtenerEspecialidadXMir(cita.getCod_mir());
        Paciente paciente = servicioPacienteDAO.obtenerPaciente(cita.getCod_pac());
        Sala sala = servicioSalaDAO.obtenerSala(cita.getCod_sal());

        return Cita.Detail.builder()
                .cod_cit(StringUtils.isBlank(cita.getCod_cit()) ? "CITA NO REGISTRADA, SOLO ES CONFIRMACIÓN DE CITA" : cita.getCod_cit())
                .especialidad(especialidad.getNombre())
                .fecha(cita.getFecha().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)))
                .hora(format_m.format(LocalTime.parse(cita.getHora())))
                .estado(estado[Integer.parseInt(String.valueOf(cita.getEstado()))])
                .medico(Cita.Medico.builder()
                        .medicoNombres(medico.getNombres())
                        .medicoApellidos(medico.getApellidos())
                        .foto(medico.getFoto()).build())
                .paciente(Cita.Paciente.builder()
                        .pacienteNombres(paciente.getNombres())
                        .pacienteApellidos(paciente.getApellidos()).build())
                .sala(Cita.Sala.builder()
                        .numero(String.format("%s%s", abc[sala.getPiso() - 1], sala.getNumero()))
                        .piso(String.valueOf(sala.getPiso())).build())
                .build();
    }

}
