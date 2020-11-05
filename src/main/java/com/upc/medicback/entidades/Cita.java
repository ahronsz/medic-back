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
    private String cod_cit;
    @NotNull
    private String cod_pac;
    @NotNull
    private String cod_mir;
    @NotNull
    private String cod_sal;
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

    public String getCod_pac() {
        return cod_pac;
    }

    public void setCod_pac(String cod_pac) {
        this.cod_pac = cod_pac;
    }

    public String getCod_mir() {
        return cod_mir;
    }

    public void setCod_mir(String cod_mir) {
        this.cod_mir = cod_mir;
    }

    public String getCod_sal() {
        return cod_sal;
    }

    public void setCod_sal(String cod_sal) {
        this.cod_sal = cod_sal;
    }
}
