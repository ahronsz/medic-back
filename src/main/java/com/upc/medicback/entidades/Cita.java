package com.upc.medicback.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Cita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cod_cit;
    @NotNull
    private char estado;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy", timezone = "GMT-5")
    @NotNull
    private LocalDate fecha;
    @NotNull
    private String hora;

    public String getCod_cit() {
        return cod_cit;
    }

    public void setCod_cit(String cod_cit) {
        this.cod_cit = cod_cit;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
