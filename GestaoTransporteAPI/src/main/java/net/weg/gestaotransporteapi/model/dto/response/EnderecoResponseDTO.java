package net.weg.gestaotransporteapi.model.dto.response;

public record EnderecoResponseDTO (
        Long id,
        String rua,
        Integer numero,
        String cidade,
        String estado,
        String bairro,
        String cep
){
}
