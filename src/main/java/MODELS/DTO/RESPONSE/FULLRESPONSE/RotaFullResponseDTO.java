package MODELS.DTO.RESPONSE.FULLRESPONSE;

import MODELS.DTO.RESPONSE.EnderecoResponseDTO;
import MODELS.DTO.RESPONSE.MotoristaRotaResponseDTO;
import lombok.Builder;

@Builder
public record RotaFullResponseDTO(Integer id,
                                  EnderecoResponseDTO origem,
                                  EnderecoResponseDTO destino,
                                  Double distancia,
                                  MotoristaRotaResponseDTO motorista) {
}
