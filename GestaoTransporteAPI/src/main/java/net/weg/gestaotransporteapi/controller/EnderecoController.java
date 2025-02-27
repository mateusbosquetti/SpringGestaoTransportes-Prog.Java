package net.weg.gestaotransporteapi.controller;

import lombok.AllArgsConstructor;
import net.weg.gestaotransporteapi.model.dto.request.EnderecoRequestDTO;
import net.weg.gestaotransporteapi.model.dto.response.EnderecoResponseDTO;
import net.weg.gestaotransporteapi.service.EnderecoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
@AllArgsConstructor
public class EnderecoController {

    private EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoResponseDTO> postEndereco(@RequestBody @Validated EnderecoRequestDTO enderecoRequestDTO) {
        return new ResponseEntity<>(service.adicionarEndereco(enderecoRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> putEndereco(@RequestBody @Validated EnderecoRequestDTO enderecoRequestDTO, @PathVariable Long id) {
        return new ResponseEntity<>(service.atualizarEndereco(enderecoRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> deleteEndereco(@PathVariable Long id) {
        return new ResponseEntity<>(service.deletarEndereco(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> getEnderecoById(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarEndereco(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<EnderecoResponseDTO>> getEndereco(Pageable pageable) {
        return new ResponseEntity<>(service.listarEndereco(pageable), HttpStatus.OK);
    }

}
