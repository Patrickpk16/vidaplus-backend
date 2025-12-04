package com.vidaplus.backend.controller;

import com.vidaplus.backend.model.Paciente;
import com.vidaplus.backend.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Paciente paciente) {
        pacienteRepository.save(paciente);
        return ResponseEntity.ok("Paciente cadastrado com sucesso!");
    }

    @GetMapping("/all")
    public List<Paciente> getAll() {
        return pacienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> getById(@PathVariable Long id) {
        return pacienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Paciente novo) {
        return pacienteRepository.findById(id).map(paciente -> {
            paciente.setNome(novo.getNome());
            paciente.setCpf(novo.getCpf());
            paciente.setDataNascimento(novo.getDataNascimento());
            paciente.setEmail(novo.getEmail());
            paciente.setTelefone(novo.getTelefone());
            paciente.setEndereco(novo.getEndereco());

            pacienteRepository.save(paciente);
            return ResponseEntity.ok("Paciente atualizado com sucesso!");
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (!pacienteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pacienteRepository.deleteById(id);
        return ResponseEntity.ok("Paciente removido com sucesso!");
    }
}
