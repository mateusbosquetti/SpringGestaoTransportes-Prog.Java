package net.weg.gestaotransporteapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(description = "Adcionar Endereço", summary = "Adicionar Endereço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })

    public ResponseEntity<EnderecoResponseDTO> postEndereco(@RequestBody @Validated EnderecoRequestDTO enderecoRequestDTO) {
        return new ResponseEntity<>(service.adicionarEndereco(enderecoRequestDTO), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(description = "Atualizar Endereço", summary = "Atualizar Endereço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<EnderecoResponseDTO> putEndereco(@RequestBody @Validated EnderecoRequestDTO enderecoRequestDTO, @PathVariable Long id) {
        return new ResponseEntity<>(service.atualizarEndereco(enderecoRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Deletar Endereço", summary = "Deletar Endereço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<EnderecoResponseDTO> deleteEndereco(@PathVariable Long id) {
        return new ResponseEntity<>(service.deletarEndereco(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(description = "Buscar Endereço", summary = "Buscar Endereço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<EnderecoResponseDTO> getEnderecoById(@PathVariable Long id) {
        return new ResponseEntity<>(service.buscarEndereco(id), HttpStatus.OK);
    }

    @GetMapping
    @Operation(description = "Listar Endereço", summary = "Listar Endereço")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Erro de Informações"),
            @ApiResponse(responseCode = "500", description = "Erro no Sistema Interno")
    })
    public ResponseEntity<Page<EnderecoResponseDTO>> getEndereco(Pageable pageable) {
        return new ResponseEntity<>(service.listarEndereco(pageable), HttpStatus.OK);
    }

}
