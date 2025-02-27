package MODELS.DTO.RESPONSE;

import lombok.Builder;

@Builder
public record RotaResponseDTO( Integer id, EnderecoResponseDTO origem, EnderecoResponseDTO destino, Double distancia ) {
}
