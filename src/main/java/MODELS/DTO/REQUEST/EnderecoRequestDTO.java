package MODELS.DTO.REQUEST;

import MODELS.ENTITY.Endereco;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public record EnderecoRequestDTO (String rua, @PositiveOrZero Integer numero, String cidade, String estado, String bairro, @NotBlank String cep ) {

    public Endereco converter () {
        return Endereco.builder()
                .rua(this.rua)
                .numero(this.numero)
                .cidade(this.cidade)
                .estado(this.estado)
                .bairro(this.bairro)
                .cep(this.cep)
                .build();
    }
}
