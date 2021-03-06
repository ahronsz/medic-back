package com.upc.medicback.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Transient;
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
        private String fechaCompleta;
        private List<String> horas;
        private List<String> horas_m;
    }
}
