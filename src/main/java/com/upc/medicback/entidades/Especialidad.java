package com.upc.medicback.entidades;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Especialidad implements Serializable {
    @Id
    private String cod_esp;
    private String nombre;
    private String image;
    private String descripcion;
}
