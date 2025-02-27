package net.weg.gestaotransporteapi.model.dto.response;

import java.time.Instant;

public record ExceptionResponseDTO (
        String mensagem,
        Class Exception,
        String erro,
        Instant instant
) {
}
