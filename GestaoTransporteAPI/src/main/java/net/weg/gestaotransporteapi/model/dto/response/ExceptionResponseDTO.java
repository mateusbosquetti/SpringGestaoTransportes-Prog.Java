package net.weg.gestaotransporteapi.model.dto.response;

public record ExceptionResponseDTO (
        String mensagem,
        String erro
) {
}
