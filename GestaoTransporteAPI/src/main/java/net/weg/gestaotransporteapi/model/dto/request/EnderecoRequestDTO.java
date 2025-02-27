package net.weg.gestaotransporteapi.model.dto.request;

import jakarta.validation.constraints.*;
import net.weg.gestaotransporteapi.model.entity.Endereco;
import org.hibernate.validator.constraints.Length;

public record EnderecoRequestDTO(
        @NotBlank String rua,
        @NotNull @Positive Integer numero,
        @NotBlank String cidade,
        @NotBlank String estado,
        @NotBlank String bairro,
        @NotBlank @Length(max = 8, min = 8) String cep
) {
    public Endereco toEntity() {
        return Endereco.builder()
                .rua(this.rua)
                .numero(this.numero)
                .cidade(this.cidade)
                .estado(this.estado)
                .bairro(this.bairro)
                .cep(this.cep)
                .build();
    }
}
