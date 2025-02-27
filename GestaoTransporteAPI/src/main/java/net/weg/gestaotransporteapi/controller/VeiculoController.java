package net.weg.gestaotransporteapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(description = "Adicionar Veiculo", summary = "Adicionar Veiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<VeiculoResponseDTO> postVeiculo(@RequestBody @Validated VeiculoRequestDTO veiculoRequestDTO) {
        return new ResponseEntity<>(service.adicionarVeiculo(veiculoRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(description = "Atualizar Veiculo", summary = "Atualizar Veiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<VeiculoResponseDTO> putVeiculo(@RequestBody @Validated VeiculoRequestDTO veiculoRequestDTO, @PathVariable Long id) {
        return new ResponseEntity<>(service.atualizarVeiculo(veiculoRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Deletar Veiculo", summary = "Deletar Veiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<VeiculoResponseDTO> deleteVeiculo(@PathVariable Long id) {
        return new ResponseEntity<>(service.deletarVeiculo(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(description = "Buscar Veiculo", summary = "Buscar Veiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<VeiculoResponseDTO> getVeiculoById(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarVeiculo(id), HttpStatus.OK);
    }

    @GetMapping
    @Operation(description = "Listar Veiculo", summary = "Listar Veiculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<Page<VeiculoResponseDTO>> getVeiculo(Pageable pageable) {
        return new ResponseEntity<>(service.listarVeiculo(pageable), HttpStatus.OK);
    }
}
