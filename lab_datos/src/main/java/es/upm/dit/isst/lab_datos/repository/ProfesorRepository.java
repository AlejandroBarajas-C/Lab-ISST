package es.upm.dit.isst.lab_datos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import es.upm.dit.isst.lab_datos.domain.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
 // Buscar un profesor exacto por su NRP
 // Equivale a: SELECT * FROM profesor WHERE nrp = ?
 Optional<Profesor> findByNrp(String nrp);
 // Buscar profesores por su nombre exacto
 List<Profesor> findByNombre(String nombre);
//Buscar profesores de un despacho concreto
 List<Profesor> findByDespacho(String despacho);
 // Buscar profesores cuyo nombre contenga un texto (LIKE %texto%)
 List<Profesor> findByNombreContaining(String nombre);
 // Buscar profesores por email que termine en @upm.es
 List<Profesor> findByEmailEndingWith(String dominio);
 // Buscar un profesor por nombre Y despacho
 List<Profesor> findByNombreAndDespacho(String nombre, String despacho);
 // Buscar profesores que estén en el despacho 'B202' O 'C212'
 List<Profesor> findByDespachoOrDespacho(String despacho1, String despacho2);
 // Buscar profesores por el acrónimo de su departamento
 // Spring entra en la entidad Departamento y busca el campo 'acronimo'
 List<Profesor> findByDepartamentoAcronimo(String acronimo);
 // Buscar profesores por el nombre de una de sus asignaturas
 List<Profesor> findByAsignaturasNombre(String nombreAsignatura);

@Query("SELECT p.nombre, COUNT(a) FROM Profesor p JOIN p.asignaturas a " +
       "GROUP BY p.id, p.nombre " +
       "HAVING COUNT(a) > 2")
List<Object[]> findProfesoresConMasDeDosAsignaturas();
}
