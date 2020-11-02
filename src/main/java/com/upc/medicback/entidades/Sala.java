package com.upc.medicback.entidades;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cod_sal;
    @NotNull
    private int piso;
    @NotNull
    private int numero;

    public String getCod_sal() {
        return cod_sal;
    }

    public void setCod_sal(String cod_sal) {
        this.cod_sal = cod_sal;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
