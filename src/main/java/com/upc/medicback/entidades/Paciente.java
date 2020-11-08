package com.upc.medicback.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Paciente implements Serializable {
    @Id
    private String cod_pac;
    @NotNull
    private String nombres;
    @NotNull
    private String apellidos;
    @NotNull
    private char tipoDoc;
    @NotNull
    private String numDoc;
    private int ubigeo;
    private String direccion;
    private char sexo;
    private String foto;
    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy", timezone = "GMT-5")
    @NotNull
    private Date fechaNaci;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @Transient
    private int edad;
}
