package net.weg.gestaotransporteapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(description = "Adicionar Rota", summary = "Adicionar Rota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<RotaResponseDTO> postRota(@RequestBody @Validated RotaRequestDTO rotaRequestDTO) {
        return new ResponseEntity<>(service.adicionarRota(rotaRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(description = "Atualizar Rota", summary = "Atualizar Rota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<RotaResponseDTO> putRota(@RequestBody @Validated RotaRequestDTO rotaRequestDTO, @PathVariable Long id) {
        return new ResponseEntity<>(service.atualizarRota(rotaRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Deletar Rota", summary = "Deletar Rota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<RotaResponseDTO> deleteRota(@PathVariable Long id) {
        return new ResponseEntity<>(service.deletarRota(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(description = "Buscar Rota", summary = "Buscar Rota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<RotaResponseDTO> getRotaById(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarRota(id), HttpStatus.OK);
    }

    @GetMapping
    @Operation(description = "Listar Rota", summary = "Listar Rota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<Page<RotaResponseDTO>> getRota(Pageable pageable) {
        return new ResponseEntity<>(service.listarRota(pageable), HttpStatus.OK);
    }
}
