package net.weg.gestaotransporteapi.model.dto.request;

import jakarta.validation.constraints.NotNull;
import net.weg.gestaotransporteapi.model.entity.Endereco;
import net.weg.gestaotransporteapi.model.entity.Motorista;
import net.weg.gestaotransporteapi.model.entity.Rota;
import net.weg.gestaotransporteapi.service.EnderecoService;
import net.weg.gestaotransporteapi.service.MotoristaService;

public record RotaRequestDTO(
        @NotNull Long origem_id,
        @NotNull Long destino_id,
        @NotNull Double distancia,
        @NotNull Long motorista_id
) {
    public Rota toEntity(EnderecoService enderecoService, MotoristaService motoristaService) {
        return Rota.builder()
                .origem(enderecoService.buscarEnderecoEntidade(this.origem_id))
                .destino(enderecoService.buscarEnderecoEntidade(this.destino_id))
                .distancia(this.distancia)
                .motorista(motoristaService.buscarMotoristaEntidade(this.motorista_id))
                .build();
    }
}
