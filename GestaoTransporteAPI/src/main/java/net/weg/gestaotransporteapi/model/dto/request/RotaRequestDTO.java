package net.weg.gestaotransporteapi.model.dto.request;

import jakarta.validation.constraints.NotNull;
import net.weg.gestaotransporteapi.model.entity.Endereco;
import net.weg.gestaotransporteapi.model.entity.Motorista;

public record RotaRequestDTO(
        @NotNull Integer origem_id,
        @NotNull Integer destino_id,
        @NotNull Double distancia,
        @NotNull Integer motorista_id
) {
}
