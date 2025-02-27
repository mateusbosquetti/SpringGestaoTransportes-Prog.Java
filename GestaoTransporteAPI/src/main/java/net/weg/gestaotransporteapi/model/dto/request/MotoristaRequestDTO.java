package net.weg.gestaotransporteapi.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.gestaotransporteapi.model.entity.Endereco;
import net.weg.gestaotransporteapi.model.entity.Motorista;
import net.weg.gestaotransporteapi.model.entity.Rota;
import net.weg.gestaotransporteapi.model.entity.Veiculo;
import net.weg.gestaotransporteapi.service.EnderecoService;

import java.util.List;

public record MotoristaRequestDTO(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String telefone,
        @NotNull Long endereco_id

) {
    public Motorista toEntity(EnderecoService enderecoService) {
        return Motorista.builder()
                .nome(this.nome)
                .email(this.email)
                .telefone(this.telefone)
                .endereco(enderecoService.buscarEnderecoEntidade(this.endereco_id))
                .build();
    }
}
