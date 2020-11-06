package com.upc.medicback.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Medico implements Serializable {
    @Id
    private String cod_med;
    @NotNull
    private String nombres;
    @NotNull
    private String apellidos;
    @NotNull
    private char tipoDoc;
    @NotNull
    private String numDoc;
    @NotNull
    private char estado;
    private int ubigeo;
    private String direccion;
    @NotNull
    private char sexo;
    private String foto;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="dd/MM/yyyy", timezone = "GMT-5")
    @NotNull
    private Date fechaNaci;
    @Transient
    private int edad;
}
