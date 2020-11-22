package com.upc.medicback.entidades;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Sala implements Serializable {
    @Id
    private String cod_sal;
    @NotNull
    private int piso;
    @NotNull
    private int numero;
    @NotNull
    private String estado;
}
