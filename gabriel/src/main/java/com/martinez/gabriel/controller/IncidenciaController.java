package com.martinez.gabriel.controller;

import com.martinez.gabriel.model.Incidencia;
import com.martinez.gabriel.service.IncidenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/gabriel")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping
    public ResponseEntity<List<Incidencia>> listar() {
        return new ResponseEntity<>(incidenciaService.listarIncidencias(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> guardar(@Valid @RequestBody Incidencia incidencia) { 
        String mensaje = incidenciaService.registrarIncidencia(incidencia);
        if (mensaje.contains("Error")) {
            return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(mensaje, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        boolean eliminado = incidenciaService.eliminarIncidencia(id);
        if (eliminado) {
            return new ResponseEntity<>("Incidencia eliminada", HttpStatus.OK);
        }
        return new ResponseEntity<>("Incidencia no encontrada", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/total")
    public ResponseEntity<Integer> obtenerTotal() {
        return ResponseEntity.ok(incidenciaService.obtenerTotalIncidencia());
    }

}
