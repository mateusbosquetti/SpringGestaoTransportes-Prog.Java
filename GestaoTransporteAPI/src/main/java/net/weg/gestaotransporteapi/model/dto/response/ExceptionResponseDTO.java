package net.weg.gestaotransporteapi.model.dto.response;

public record ExceptionResponseDTO (
        String mensagem,
        Class Exception,
        String erro
) {
}
