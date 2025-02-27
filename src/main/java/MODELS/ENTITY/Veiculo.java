package MODELS.ENTITY;

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
}
