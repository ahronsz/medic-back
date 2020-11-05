package com.upc.medicback.repositorio;

import com.upc.medicback.entidades.Cita;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioCita extends CrudRepository<Cita, String> {
    @Query(value = "SELECT cod_mir FROM especialidad_medico WHERE cod_med = :cod_med and cod_esp = :cod_esp", nativeQuery = true)
    public String buscarMedicoEspecialidad(String cod_med, String cod_esp);

    @Query(value = "SELECT * FROM cita WHERE cod_mir = :cod_mir AND DATE_FORMAT(fecha, \"%d/%m/%Y\") = :fecha", nativeQuery = true)
    public List<Cita> listarCitasXDia(String cod_mir, String fecha);
    //TIME_FORMAT(hora, "%h:%i %p")
}
