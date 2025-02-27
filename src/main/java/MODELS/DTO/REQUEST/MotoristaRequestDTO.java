package MODELS.DTO.REQUEST;

import MODELS.ENTITY.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MotoristaRequestDTO(@NotBlank String nome, @NotBlank String email, String telefone, @NotNull Endereco endereco) {
}
