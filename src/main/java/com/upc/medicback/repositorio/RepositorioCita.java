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

    @Query(value = "SELECT c.* FROM cita c INNER JOIN especialidad_medico em ON em.cod_mir = c.cod_mir WHERE DATE_FORMAT(fecha, \"%d/%m/%Y\") = :fecha AND em.cod_esp = :cod_esp", nativeQuery = true)
    public List<Cita> listarCitasXDiaEspecialidad(String cod_esp, String fecha);

    @Query(value = "select concat('cit_', ((select substring_index((SELECT MAX(cod_cit) FROM cita), '_', -1)+1)))", nativeQuery = true)
    public String obtenerCodigo();

    @Query(value = "INSERT INTO cita VALUES (:cod_cit, :cod_pac, :cod_mir, :cod_sal, :estado, :fecha, :hora)", nativeQuery = true)
    public Cita registrarCita(String cod_cit, String cod_pac, String cod_mir, String cod_sal, char estado, String fecha, String hora);
}
