package net.weg.gestaotransporteapi.model.dto.response;

import jakarta.persistence.CascadeType;
import net.weg.gestaotransporteapi.model.entity.Motorista;

public record VeiculoResponseDTO(
        Long id,
        String marca,
        String modelo,
        String placa,
        MotoristaResponseDTO motorista
) {
}
