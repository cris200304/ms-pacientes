package com.rednorte.mspacientes.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PacienteResponse {

    private Long id;
    private String rut;
    private String nombre;
    private String correo;
    private String telefono;
    private String historial;
}