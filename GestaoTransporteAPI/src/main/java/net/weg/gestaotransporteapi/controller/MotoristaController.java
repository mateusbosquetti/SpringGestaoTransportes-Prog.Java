package net.weg.gestaotransporteapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(description = "Adicionar Motorista", summary = "Adicionar Motorista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<MotoristaResponseDTO> postMotorista(@RequestBody @Validated MotoristaRequestDTO motoristaRequestDTO) {
        return new ResponseEntity<>(service.adicionarMotorista(motoristaRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(description = "Atualizar Motorista", summary = "Atualizar Motorista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<MotoristaResponseDTO> putMotorista(@RequestBody @Validated MotoristaRequestDTO motoristaRequestDTO, @PathVariable Long id) {
        return new ResponseEntity<>(service.atualizarMotorista(motoristaRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Deletar Motorista", summary = "Deletar Motorista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<MotoristaResponseDTO> deleteMotorista(@PathVariable Long id) {
        return new ResponseEntity<>(service.deletarMotorista(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(description = "Buscar Motorista", summary = "Buscar Motorista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<MotoristaResponseDTO> getMotoristaById(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarMotorista(id), HttpStatus.OK);
    }

    @GetMapping
    @Operation(description = "Listar Motorista", summary = "Listar Motorista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<Page<MotoristaResponseDTO>> getMotorista(Pageable pageable) {
        return new ResponseEntity<>(service.listarMotorista(pageable), HttpStatus.OK);
    }}
