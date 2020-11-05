package com.upc.medicback.repositorio;

import com.upc.medicback.entidades.Especialidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioEspecialidad extends CrudRepository<Especialidad, String> {
//    @Query("")
//    public List<Especialidad> listarEspecialidadesXMedico(String cod_med);
}
