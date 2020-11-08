package com.upc.medicback.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

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
    private char estado;
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    @NotNull
    private LocalDate fecha;
    @NotNull
    private String hora;
}
