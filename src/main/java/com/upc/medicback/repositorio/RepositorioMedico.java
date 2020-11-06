package com.upc.medicback.repositorio;

import com.upc.medicback.entidades.Medico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioMedico extends CrudRepository<Medico, String> {
    @Query(value = "select m.* from medico m inner join especialidad_medico on especialidad_medico.cod_med = m.cod_med where especialidad_medico.cod_esp = :cod_esp", nativeQuery = true)
    public List<Medico> listarMedicoXEspecialidad(String cod_esp);
}
