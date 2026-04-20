package es.upm.dit.isst.lab_datos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import es.upm.dit.isst.lab_datos.domain.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
 // Aquí irían los métodos de consulta personalizados para la entidad Asignatura
 Optional<Asignatura> findByAcronimo(String acronimo);
 // Buscar asignaturas por su nombre exacto     
 List<Asignatura> findByNombre(String nombre);
// Buscar asignaturas por nombre que contenga un texto (LIKE %texto%)   
 List<Asignatura> findByNombreContaining(String nombre);
 // Buscar asignaturas por el acrónimo del departamento al que pertenecen
 List<Asignatura> findByDepartamentoNombre(String nombreDepartamento);
 // Buscar asignaturas por el acrónimo del departamento al que pertenecen
 List<Asignatura> findByDepartamentoAcronimo(String acronimoDepartamento);
 // Buscar asignaturas por el nombre de uno de sus profesores               
 List<Asignatura> findByDepartamentoProfesoresNombre(String nombreProfesor);
// Buscar asignaturas por el despacho de uno de sus profesores  
 List<Asignatura> findByDepartamentoProfesoresDespacho(String despachoProfesor);
 // Buscar asignaturas por el acrónimo del departamento de uno de sus profesores
 List<Asignatura> findByDepartamentoProfesoresDepartamentoAcronimo(String acronimoDepartamentoProfesor);
}