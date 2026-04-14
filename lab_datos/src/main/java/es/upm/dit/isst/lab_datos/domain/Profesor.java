package es.upm.dit.isst.lab_datos.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Profesor {
@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nrp; // Número de Registro de Personal
 private String nombre;
 private String despacho;
 private String email;
 // Muchos profesores pertenecen a un departamento (0..1)
 @ManyToOne
 @JoinColumn(name = "id_departamento")
 private Departamento departamento;
 // Muchos profesores imparten muchas asignaturas
 @ManyToMany
 @JoinTable(
 name = "profesor_imparte_asignatura",
 joinColumns = @JoinColumn(name = "id_profesor"),
 inverseJoinColumns = @JoinColumn(name = "id_asignatura")
 )
 private List<Asignatura> asignaturas;
}
