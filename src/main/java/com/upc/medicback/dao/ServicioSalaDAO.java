package com.upc.medicback.dao;

import com.upc.medicback.entidades.Sala;

public interface ServicioSalaDAO {
    Sala obtenerSala(String cod_sal);
    Sala editarSala(Sala sala);
}
