package MODELS.DTO.REQUEST;

import MODELS.ENTITY.Veiculo;
import jakarta.validation.constraints.NotBlank;

public record VeiculoRequestDTO(@NotBlank String placa, @NotBlank String modelo, @NotBlank String marca ) {
    public Veiculo converter() {
        return Veiculo.builder()
                .placa(this.placa)
                .modelo(this.modelo)
                .marca(this.marca)
                .build();
    }
}
