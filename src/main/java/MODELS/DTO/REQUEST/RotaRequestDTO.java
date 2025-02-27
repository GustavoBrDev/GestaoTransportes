package MODELS.DTO.REQUEST;

import MODELS.ENTITY.Endereco;
import MODELS.ENTITY.Motorista;
import jakarta.validation.constraints.NotNull;

public record RotaRequestDTO(@NotNull Endereco origem, @NotNull Endereco destino, Double distancia, Motorista motorista) {
}
