package com.upc.medicback.repositorio;

import com.upc.medicback.entidades.Paciente;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioPaciente extends CrudRepository<Paciente, String> {
}
