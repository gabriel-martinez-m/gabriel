package com.martinez.gabriel.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Incidencia {

    @NotBlank(message = "El ID es obligatoria")
    private String id;
    @NotBlank(message = "La descripcion no puede estar vacía")
    private String descripcion;
    private String estado;
    @NotNull(message = "El nivel deben ser números")
    private int nivelPrioridad;
    @NotBlank(message = "El usuario es obligatorio")
    private String usuario;
    @NotBlank(message = "Debe especificar la fecha")
    private String fecha;

}
