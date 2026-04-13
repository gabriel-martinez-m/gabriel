package com.martinez.gabriel.service;

import com.martinez.gabriel.model.Incidencia;
import com.martinez.gabriel.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IncidenciaService {

    @Autowired //
    private IncidenciaRepository incidenciaRepository;

    public List<Incidencia> listarIncidencias() {
        return incidenciaRepository.obtenerTodos();
    }

    public String registrarIncidencia(Incidencia incidencia) {
        if (incidenciaRepository.buscarPorId(incidencia.getId()) != null) {
            return "Error: Ya existe una incidencia con ese ID";
        }
        incidenciaRepository.guardar(incidencia);
        return "incidencia registrada con éxito";
    }

    public boolean eliminarIncidencia(String id) {
        return incidenciaRepository.eliminar(id);
    }
    public int obtenerTotalIncidencia() {
        return incidenciaRepository.obtenerTodos().size();
    }
}