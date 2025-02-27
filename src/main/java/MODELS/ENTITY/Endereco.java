package MODELS.ENTITY;

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
}
