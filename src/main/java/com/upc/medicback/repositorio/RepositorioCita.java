package com.upc.medicback.repositorio;

import com.upc.medicback.entidades.Cita;
import com.upc.medicback.entidades.EspecialidadMedico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioCita extends CrudRepository<Cita, String> {

    @Query(value = "SELECT cod_mir FROM especialidad_medico WHERE cod_med = :cod_med and cod_esp = :cod_esp", nativeQuery = true)
    String buscarMedicoEspecialidad(String cod_med, String cod_esp);

    @Query(value = "SELECT * FROM cita WHERE cod_mir = :cod_mir AND DATE_FORMAT(fecha, \"%d/%m/%Y\") = :fecha", nativeQuery = true)
    List<Cita> listarCitasXDia(String cod_mir, String fecha);

    @Query(value = "SELECT c.* FROM cita c INNER JOIN especialidad_medico em ON em.cod_mir = c.cod_mir WHERE DATE_FORMAT(fecha, \"%d/%m/%Y\") = :fecha AND em.cod_esp = :cod_esp", nativeQuery = true)
    List<Cita> listarCitasXDiaEspecialidad(String cod_esp, String fecha);

    @Query(value = "SELECT h.start_hora, h.end_hora FROM hora h INNER JOIN especialidad_medico em ON em.cod_hor = h.cod_hor WHERE em.cod_mir = :cod_mir", nativeQuery = true)
    EspecialidadMedico.Hora obtenerHoraXMIR(String cod_mir);

    @Query(value = "CALL get_code_cit", nativeQuery = true)
    String obtenerCodigo();

    @Query(value = "SELECT h.end_hora FROM hora h INNER JOIN especialidad_medico em ON em.cod_hor = h.cod_hor WHERE em.cod_mir = :cod_mir", nativeQuery = true)
    String obtenerHoraEndXMIR(String cod_mir);

    @Query(value = "SELECT h.start_hora FROM hora h INNER JOIN especialidad_medico em ON em.cod_hor = h.cod_hor WHERE em.cod_mir = :cod_mir", nativeQuery = true)
    String obtenerHoraStartXMIR(String cod_mir);
}
