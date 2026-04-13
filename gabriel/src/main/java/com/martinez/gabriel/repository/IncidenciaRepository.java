package com.martinez.gabriel.repository;

import com.martinez.gabriel.model.Incidencia;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IncidenciaRepository {


    private List<Incidencia> listaIncidencias = new ArrayList<>();

    public List<Incidencia> obtenerTodos() {
        return listaIncidencias;
    }

    public void guardar(Incidencia incidencia) {
        listaIncidencias.add(incidencia);
    }

    public Incidencia buscarPorId(String id) {
        
        return listaIncidencias.stream()
                .filter(v -> v.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public boolean eliminar(String id) {
        return listaIncidencias.removeIf(v -> v.getId().equalsIgnoreCase(id));
    }
}
