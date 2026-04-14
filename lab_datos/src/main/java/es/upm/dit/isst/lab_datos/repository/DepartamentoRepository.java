package es.upm.dit.isst.lab_datos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import es.upm.dit.isst.lab_datos.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
 // Buscar un departamento por su acrónimo exacto
 Optional<Departamento> findByAcronimo(String acronimo);
 // Buscar departamentos por su nombre exacto
 List<Departamento> findByNombre(String nombre);
 // Buscar departamentos por nombre que contenga un texto (LIKE %texto%)
 List<Departamento> findByNombreContaining(String nombre);
 // Buscar departamentos por el nombre de uno de sus profesores
 List<Departamento> findByProfesoresNombre(String nombreProfesor);
 // Buscar departamentos por el despacho de uno de sus profesores
 List<Departamento> findByProfesoresDespacho(String despacho);
// Buscar departamentos por el acrónimo del departamento de uno de sus profesores
List<Departamento> findByProfesoresDepartamentoAcronimo(String acronimo);
// Buscar departamentos por el nombre de una de sus asignaturas
List<Departamento> findByAsignaturasNombre(String nombreAsignatura);
// Buscar departamentos por el acrónimo del departamento de una de sus asignaturas
List<Departamento> findByAsignaturasDepartamentoAcronimo(String acronimo);
}