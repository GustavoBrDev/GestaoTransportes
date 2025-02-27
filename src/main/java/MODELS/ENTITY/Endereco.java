package MODELS.ENTITY;

import MODELS.DTO.RESPONSE.EnderecoResponseDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.EnderecoFullResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;
    private String bairro;
    @Column ( nullable = false)
    private String cep;

    public EnderecoResponseDTO converterSemId (){
        return EnderecoResponseDTO.builder()
                .rua(this.rua)
                .numero(this.numero)
                .cidade(this.cidade)
                .estado(this.estado)
                .bairro(this.bairro)
                .cep(this.cep)
                .build();
    }

    public EnderecoFullResponseDTO converter (){
        return EnderecoFullResponseDTO.builder()
                .rua(this.rua)
                .numero(this.numero)
                .cidade(this.cidade)
                .estado(this.estado)
                .bairro(this.bairro)
                .cep(this.cep)
                .id(this.id)
                .build();
    }
}
