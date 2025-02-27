package net.weg.gestaotransporteapi.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.gestaotransporteapi.model.entity.Endereco;
import net.weg.gestaotransporteapi.model.entity.Rota;
import net.weg.gestaotransporteapi.model.entity.Veiculo;

import java.util.List;

public record MotoristaRequestDTO(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String telefone,
        @NotNull Integer endereco_id

) {
}
