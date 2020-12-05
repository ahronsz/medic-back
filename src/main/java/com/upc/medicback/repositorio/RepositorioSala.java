package com.upc.medicback.repositorio;

import com.upc.medicback.entidades.Sala;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioSala extends CrudRepository<Sala, String> {
    @Query(value = "SELECT * FROM sala ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Sala obtenerSalaRandom();
}
