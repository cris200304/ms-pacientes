package com.rednorte.mspacientes.service;

import com.rednorte.mspacientes.dto.PacienteRequest;
import com.rednorte.mspacientes.dto.PacienteResponse;

import java.util.List;

public interface PacienteService {

    PacienteResponse crearPaciente(PacienteRequest request);

    List<PacienteResponse> listarPacientes();

    PacienteResponse obtenerPaciente(Long id);

    void eliminarPaciente(Long id);
}