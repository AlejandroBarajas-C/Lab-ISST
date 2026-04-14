package es.upm.dit.isst.lab_datos.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Asignatura {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nombre;
 private String acronimo;
 private String curso;
 private String semestre;
 // Muchas asignaturas pertenecen a un Departamento
 @ManyToOne
 @JoinColumn(name = "id_departamento")
 private Departamento departamento;
 // Muchas asignaturas son impartidas por muchos profesores
 @ManyToMany(mappedBy = "asignaturas")
 private List<Profesor> profesores;
}
