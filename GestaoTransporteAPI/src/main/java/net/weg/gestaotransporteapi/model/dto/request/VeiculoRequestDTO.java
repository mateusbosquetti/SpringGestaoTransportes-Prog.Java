package net.weg.gestaotransporteapi.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.gestaotransporteapi.model.entity.Veiculo;
import net.weg.gestaotransporteapi.service.MotoristaService;

public record VeiculoRequestDTO(
        @NotBlank String marca,
        @NotBlank String modelo,
        @NotBlank String placa,
        @NotNull Long motorista_id
) {
    public Veiculo toEntity(MotoristaService motoristaService) {
        return Veiculo.builder()
                .marca(this.marca)
                .modelo(this.modelo)
                .placa(this.placa)
                .motorista(motoristaService.buscarMotoristaEntidade(this.motorista_id))
                .build();
    }
}
