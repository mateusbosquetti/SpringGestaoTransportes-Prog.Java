package net.weg.gestaotransporteapi.model.dto.response;

import jakarta.persistence.CascadeType;
import net.weg.gestaotransporteapi.model.entity.Endereco;
import net.weg.gestaotransporteapi.model.entity.Motorista;

public record RotaResponseDTO(
        Long id,
        Endereco origem,
        Endereco destino,
        Double distancia,
        MotoristaResponseDTO motorista
) {
}
