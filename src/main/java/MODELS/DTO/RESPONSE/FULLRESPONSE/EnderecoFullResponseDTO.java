package MODELS.DTO.RESPONSE.FULLRESPONSE;

import lombok.Builder;

@Builder
public record EnderecoFullResponseDTO( String rua, Integer numero, String cidade, String estado, String bairro, String cep, Integer id ) {
}
