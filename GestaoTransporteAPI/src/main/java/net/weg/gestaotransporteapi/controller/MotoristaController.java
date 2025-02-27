package net.weg.gestaotransporteapi.controller;

import lombok.AllArgsConstructor;
import net.weg.gestaotransporteapi.model.dto.request.MotoristaRequestDTO;
import net.weg.gestaotransporteapi.model.dto.response.MotoristaResponseDTO;
import net.weg.gestaotransporteapi.service.MotoristaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/motorista")
@AllArgsConstructor
public class MotoristaController {

    private MotoristaService service;

    @PostMapping
    public ResponseEntity<MotoristaResponseDTO> postMotorista(@RequestBody @Validated MotoristaRequestDTO motoristaRequestDTO) {
        return new ResponseEntity<>(service.adicionarMotorista(motoristaRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoristaResponseDTO> putMotorista(@RequestBody @Validated MotoristaRequestDTO motoristaRequestDTO, @PathVariable Long id) {
        return new ResponseEntity<>(service.atualizarMotorista(motoristaRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MotoristaResponseDTO> deleteMotorista(@PathVariable Long id) {
        return new ResponseEntity<>(service.deletarMotorista(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaResponseDTO> getMotoristaById(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarMotorista(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Page<MotoristaResponseDTO>> getMotorista(Pageable pageable) {
        return new ResponseEntity<>(service.listarMotorista(pageable), HttpStatus.OK);
    }}
