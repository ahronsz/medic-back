package com.upc.medicback.repositorio;

import com.upc.medicback.entidades.Especialidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEspecialidad extends CrudRepository<Especialidad, String> {
}
