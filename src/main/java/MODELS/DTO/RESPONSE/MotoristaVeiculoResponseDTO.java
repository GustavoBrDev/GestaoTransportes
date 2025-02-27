package MODELS.DTO.RESPONSE;

import lombok.Builder;

import java.util.List;

@Builder
public record MotoristaVeiculoResponseDTO(Integer id, String nome, String telefone, String email, EnderecoResponseDTO endereco, List<RotaResponseDTO> rotas) {
}
