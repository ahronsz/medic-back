package com.upc.medicback.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Medico implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
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

    public String getCod_med() {
        return cod_med;
    }

    public void setCod_med(String cod_med) {
        this.cod_med = cod_med;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public char getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(char tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(int ubigeo) {
        this.ubigeo = ubigeo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(Date fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
