package MODELS.ENTITY;

import MODELS.DTO.RESPONSE.FULLRESPONSE.VeiculoFullResponseDTO;
import MODELS.DTO.RESPONSE.VeiculoResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Veiculo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modelo;
    private String marca;
    private String placa;
    @ManyToOne
    private Motorista motorista;

    public VeiculoResponseDTO converterSemMotorista (){
        return VeiculoResponseDTO.builder()
                .id(this.id)
                .marca(this.marca)
                .modelo(this.modelo)
                .placa(this.placa)
                .build();
    }

    public VeiculoFullResponseDTO converter () {
        return VeiculoFullResponseDTO.builder()
                .id(this.id)
                .marca(this.marca)
                .modelo(this.modelo)
                .placa(this.placa)
                .motorista(this.motorista.converterSemVeiculo())
                .build();
    }
}
