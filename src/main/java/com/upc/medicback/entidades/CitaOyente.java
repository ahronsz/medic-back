package com.upc.medicback.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitaOyente {
    private String cod_pac;
    private String cod_med;
    private String cod_esp;
    private String fecha;
    private String hora;
}
