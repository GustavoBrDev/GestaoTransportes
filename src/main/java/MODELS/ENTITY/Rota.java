package MODELS.ENTITY;

import MODELS.DTO.RESPONSE.FULLRESPONSE.RotaFullResponseDTO;
import MODELS.DTO.RESPONSE.RotaResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rota {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private Endereco origem;

    @ManyToOne
    @Cascade(CascadeType.PERSIST)
    private Endereco destino;

    private Double distancia;

    @ManyToOne
    private Motorista motorista;

    public RotaFullResponseDTO converter() {
        return RotaFullResponseDTO.builder()
                .id(this.id)
                .origem(this.origem.converterSemId())
                .destino(this.destino.converterSemId())
                .distancia(this.distancia)
                .motorista(this.motorista.converterSemRotas())
                .build();
    }

    public RotaResponseDTO converterSemMotorista() {
        return RotaResponseDTO.builder()
                .id(this.id)
                .origem(this.origem.converterSemId())
                .destino(this.destino.converterSemId())
                .distancia(this.distancia)
                .build();
    }
}
