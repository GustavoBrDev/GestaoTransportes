package MODELS.DTO.REQUEST;

import MODELS.ENTITY.Endereco;
import MODELS.ENTITY.Motorista;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MotoristaRequestDTO(@NotBlank String nome, @NotBlank String email, String telefone, @NotNull Endereco endereco) {
    public Motorista converter() {
        return Motorista.builder()
                .nome(nome)
                .email(email)
                .telefone(telefone)
                .endereco(endereco)
                .build();
    }
}
