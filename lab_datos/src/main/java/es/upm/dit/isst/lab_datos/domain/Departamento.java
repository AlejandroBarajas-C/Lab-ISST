package es.upm.dit.isst.lab_datos.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Id; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class Departamento {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String nombre;
 private String acronimo;
 // Un departamento organiza muchas asignaturas
 @OneToMany(mappedBy = "departamento")
 @JsonIgnore
 private List<Asignatura> asignaturas;
 // Un departamento tiene asignados profesores (0..1 a 1..*)
 @OneToMany(mappedBy = "departamento")
 @JsonIgnore
 private List<Profesor> profesores;
}
