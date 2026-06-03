package com.rednorte.mspacientes.service;

import com.rednorte.mspacientes.dto.PacienteRequest;
import com.rednorte.mspacientes.dto.PacienteResponse;
import com.rednorte.mspacientes.model.Paciente;
import com.rednorte.mspacientes.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    @Override
    public PacienteResponse crearPaciente(PacienteRequest request) {

        Paciente paciente = Paciente.builder()
                .rut(request.getRut())
                .nombre(request.getNombre())
                .correo(request.getCorreo())
                .telefono(request.getTelefono())
                .historial(request.getHistorial())
                .build();

        Paciente guardado = pacienteRepository.save(paciente);

        return PacienteResponse.builder()
                .id(guardado.getId())
                .rut(guardado.getRut())
                .nombre(guardado.getNombre())
                .correo(guardado.getCorreo())
                .telefono(guardado.getTelefono())
                .historial(guardado.getHistorial())
                .build();
    }

    @Override
    public List<PacienteResponse> listarPacientes() {

        return pacienteRepository.findAll()
                .stream()
                .map(paciente -> PacienteResponse.builder()
                        .id(paciente.getId())
                        .rut(paciente.getRut())
                        .nombre(paciente.getNombre())
                        .correo(paciente.getCorreo())
                        .telefono(paciente.getTelefono())
                        .historial(paciente.getHistorial())
                        .build())
                .toList();
    }

    @Override
    public PacienteResponse obtenerPaciente(Long id) {

        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        return PacienteResponse.builder()
                .id(paciente.getId())
                .rut(paciente.getRut())
                .nombre(paciente.getNombre())
                .correo(paciente.getCorreo())
                .telefono(paciente.getTelefono())
                .historial(paciente.getHistorial())
                .build();
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}