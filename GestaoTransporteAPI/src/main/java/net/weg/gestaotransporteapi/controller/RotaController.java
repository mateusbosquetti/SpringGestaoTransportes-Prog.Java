package net.weg.gestaotransporteapi.controller;

import lombok.AllArgsConstructor;
import net.weg.gestaotransporteapi.model.dto.request.RotaRequestDTO;
import net.weg.gestaotransporteapi.model.dto.response.RotaResponseDTO;
import net.weg.gestaotransporteapi.service.RotaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rota")
@AllArgsConstructor
public class RotaController {

    private RotaService service;

    @PostMapping
    public ResponseEntity<RotaResponseDTO> postRota(@RequestBody @Validated RotaRequestDTO rotaRequestDTO) {
        return new ResponseEntity<>(service.adicionarRota(rotaRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RotaResponseDTO> putRota(@RequestBody @Validated RotaRequestDTO rotaRequestDTO, @PathVariable Long id) {
        return new ResponseEntity<>(service.atualizarRota(rotaRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RotaResponseDTO> deleteRota(@PathVariable Long id) {
        return new ResponseEntity<>(service.deletarRota(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RotaResponseDTO> getRotaById(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarRota(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<RotaResponseDTO>> getRota(Pageable pageable) {
        return new ResponseEntity<>(service.listarRota(pageable), HttpStatus.OK);
    }
}
