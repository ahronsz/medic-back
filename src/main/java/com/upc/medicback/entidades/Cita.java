package com.upc.medicback.entidades;

import com.sun.istack.NotNull;
import org.apache.tomcat.jni.Local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Cita implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cod_cit;
    @NotNull
    private char estado;
    @NotNull
    private LocalDate fecha;
    @NotNull
    private LocalDateTime hora;

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

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
}
