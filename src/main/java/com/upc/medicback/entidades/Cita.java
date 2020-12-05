package com.upc.medicback.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
public class Cita implements Serializable {
    @Id
    private String cod_cit;
    @NotNull
    private String cod_pac;
    @NotNull
    private String cod_mir;
    @NotNull
    private String cod_sal;
    private String estado;
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    @NotNull
    private LocalDate fecha;
    @NotNull
    private String hora;
    @Transient
    private String cod_med;
    @Transient
    private String cod_esp;
    @Transient
    private Detail detail;

    @Builder
    @Data
    public static class Detail {
        private String cod_cit;
        private String especialidad;
        private String fecha;
        private String hora;
        private String estado;
        private Medico medico;
        private Sala sala;
        private Paciente paciente;
    }

    @Builder
    @Data
    public static class Paciente {
        private String nombres;
        private String apellidos;
    }

    @Builder
    @Data
    public static class Medico {
        private String tipo;
        private String nombres;
        private String apellidos;
        private String foto;
    }

    @Builder
    @Data
    public static class Sala {
        private String numero;
        private String piso;
    }

}
