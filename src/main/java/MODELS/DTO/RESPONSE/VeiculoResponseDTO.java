package MODELS.DTO.RESPONSE;

import lombok.Builder;

@Builder
public record VeiculoResponseDTO( Integer id, String marca, String modelo, String placa ) {
}
