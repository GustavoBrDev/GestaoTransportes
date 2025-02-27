package MODELS.DTO.RESPONSE.FULLRESPONSE;

import MODELS.DTO.RESPONSE.EnderecoResponseDTO;
import MODELS.DTO.RESPONSE.RotaResponseDTO;
import MODELS.DTO.RESPONSE.VeiculoResponseDTO;
import lombok.Builder;

import java.util.List;

@Builder
public record MotoristaFullResponseDTO (Integer id, String nome, String telefone, String email, EnderecoResponseDTO endereco, List<VeiculoResponseDTO> veiculos, List<RotaResponseDTO> rotas ) {

}
