package com.upc.medicback.repositorio;

import com.upc.medicback.entidades.Especialidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEspecialidad extends CrudRepository<Especialidad, String> {
    @Query(value = "SELECT e.* FROM especialidad e INNER JOIN especialidad_medico em ON em.cod_esp = e.cod_esp WHERE em.cod_mir = :cod_mir", nativeQuery = true)
    Especialidad obtenerEspecialidadXMir(String cod_mir);
}
