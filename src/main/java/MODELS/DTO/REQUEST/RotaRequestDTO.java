package MODELS.DTO.REQUEST;

import MODELS.ENTITY.Endereco;
import MODELS.ENTITY.Motorista;
import MODELS.ENTITY.Rota;
import jakarta.validation.constraints.NotNull;

public record RotaRequestDTO(@NotNull Endereco origem, @NotNull Endereco destino, Double distancia, Motorista motorista) {
    public Rota converter() {
        return Rota.builder()
                .origem(this.origem)
                .destino(this.destino)
                .distancia(this.distancia)
                .motorista(this.motorista)
                .build();
    }
}
