package net.weg.gestaotransporteapi.model.dto.response;

import net.weg.gestaotransporteapi.model.entity.Rota;
import net.weg.gestaotransporteapi.model.entity.Veiculo;

import java.util.List;

public record MotoristaResponseDTO(
        Long id,
        String nome,
        String email,
        String telefone,
        EnderecoResponseDTO endereco
) {
}
