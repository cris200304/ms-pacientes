package com.rednorte.mspacientes.controller;

import com.rednorte.mspacientes.dto.PacienteRequest;
import com.rednorte.mspacientes.dto.PacienteResponse;
import com.rednorte.mspacientes.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public PacienteResponse crearPaciente(@RequestBody PacienteRequest request) {
        return pacienteService.crearPaciente(request);
    }

    @GetMapping
    public List<PacienteResponse> listarPacientes() {
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public PacienteResponse obtenerPaciente(@PathVariable Long id) {
        return pacienteService.obtenerPaciente(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPaciente(@PathVariable Long id) {
        pacienteService.eliminarPaciente(id);
    }
}