package net.weg.gestaotransporteapi.model.dto.request;

import jakarta.validation.constraints.*;

public record EnderecoRequestDTO(
        @NotBlank String rua,
        @NotNull @Positive Integer numero,
        @NotBlank String cidade,
        @NotBlank String estado,
        @NotBlank String bairro,
        @NotBlank @Min(8) @Max(8) String cep
) {
}
