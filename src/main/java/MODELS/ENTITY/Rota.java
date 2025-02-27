package MODELS.ENTITY;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rota {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String origem;
    private String destino;
    private Double distancia;

    @ManyToOne
    private Motorista motorista;
}
