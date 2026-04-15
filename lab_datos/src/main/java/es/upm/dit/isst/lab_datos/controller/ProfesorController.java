package es.upm.dit.isst.lab_datos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.upm.dit.isst.lab_datos.domain.Profesor;
import es.upm.dit.isst.lab_datos.repository.ProfesorRepository;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
 @Autowired
 private ProfesorRepository profesorRepository;
 // Obtener todos: http://localhost:8080/api/profesores
 @GetMapping
 public List<Profesor> getAll() {
 return profesorRepository.findAll();
 }
 // Buscar por NRP: http://localhost:8080/api/profesores/nrp/123456
 @GetMapping("/nrp/{nrp}")
 public ResponseEntity<Profesor> getByNrp(@PathVariable String nrp) {
 return profesorRepository.findByNrp(nrp)
 .map(ResponseEntity::ok)
 .orElse(ResponseEntity.notFound().build());
 }
 // Buscar por nombre: http://localhost:8080/api/profesores/buscar?nombre=Juan
 @GetMapping("/buscar")
 public List<Profesor> searchByNombre(@RequestParam String nombre) {
 return profesorRepository.findByNombreContaining(nombre);
 }
}