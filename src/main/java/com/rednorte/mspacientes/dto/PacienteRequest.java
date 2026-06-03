package com.rednorte.mspacientes.dto;

import lombok.Data;

@Data
public class PacienteRequest {

    private String rut;
    private String nombre;
    private String correo;
    private String telefono;
    private String historial;
}