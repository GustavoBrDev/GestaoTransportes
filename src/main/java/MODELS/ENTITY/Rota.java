package MODELS.ENTITY;

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
}
