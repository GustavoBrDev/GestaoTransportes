package MODELS.DTO.RESPONSE.FULLRESPONSE;

import MODELS.DTO.RESPONSE.MotoristaVeiculoResponseDTO;
import lombok.Builder;

@Builder
public record VeiculoFullResponseDTO(Integer id, String marca, String modelo, String placa, MotoristaVeiculoResponseDTO motorista) {
}
