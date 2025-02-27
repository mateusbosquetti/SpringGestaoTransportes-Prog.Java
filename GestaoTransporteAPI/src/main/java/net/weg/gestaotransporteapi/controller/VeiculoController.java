package net.weg.gestaotransporteapi.controller;

import lombok.AllArgsConstructor;
import net.weg.gestaotransporteapi.model.dto.request.VeiculoRequestDTO;
import net.weg.gestaotransporteapi.model.dto.response.VeiculoResponseDTO;
import net.weg.gestaotransporteapi.service.VeiculoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculo")
@AllArgsConstructor
public class VeiculoController {

    private VeiculoService service;

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> postVeiculo(@RequestBody @Validated VeiculoRequestDTO veiculoRequestDTO) {
        return new ResponseEntity<>(service.adicionarVeiculo(veiculoRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> putVeiculo(@RequestBody @Validated VeiculoRequestDTO veiculoRequestDTO, @PathVariable Long id) {
        return new ResponseEntity<>(service.atualizarVeiculo(veiculoRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> deleteVeiculo(@PathVariable Long id) {
        return new ResponseEntity<>(service.deletarVeiculo(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponseDTO> getVeiculoById(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarVeiculo(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<VeiculoResponseDTO>> getVeiculo(Pageable pageable) {
        return new ResponseEntity<>(service.listarVeiculo(pageable), HttpStatus.OK);
    }
}
