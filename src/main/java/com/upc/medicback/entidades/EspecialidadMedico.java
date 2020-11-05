package com.upc.medicback.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


public class EspecialidadMedico implements Serializable {
    private String cod_med;
    private String cod_esp;
    @Column
    @JsonFormat(pattern="dd/MM/yyyy", timezone = "GMT-5")
    @NotNull
    private LocalDate fecha;
    private List<String> horas;

    public String getCod_med() {
        return cod_med;
    }

    public void setCod_med(String cod_med) {
        this.cod_med = cod_med;
    }

    public String getCod_esp() {
        return cod_esp;
    }

    public void setCod_esp(String cod_esp) {
        this.cod_esp = cod_esp;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<String> getHoras() {
        return horas;
    }

    public void setHoras(List<String> horas) {
        this.horas = horas;
    }
}
