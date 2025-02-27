package MODELS.DTO.RESPONSE;

import lombok.Builder;

@Builder
public record EnderecoResponseDTO( String rua, Integer numero, String cidade, String estado, String bairro, String cep ) {
}
