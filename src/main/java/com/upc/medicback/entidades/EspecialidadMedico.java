package com.upc.medicback.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class EspecialidadMedico implements Serializable {
    private String cod_med;
    private String cod_esp;
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    @NotNull
    private LocalDate fecha;
    private Hora hora;

    @Data
    public static class Hora {
        private List<String> horas;
        private List<String> horas_m;
    }

    @Data
    public static class HoraLaboral {
        private String start_hora;
        private String end_hora;
    }
}
