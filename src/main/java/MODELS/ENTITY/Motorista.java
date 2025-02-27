package MODELS.ENTITY;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Motorista {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column ( nullable = false)
    private String nome;

    @Column ( nullable = false)
    private String email;

    private String telefone;

    @JoinColumn ( nullable = false)
    @Cascade(CascadeType.PERSIST)
    @ManyToOne
    private Endereco endereco;

    @OneToMany
    private List<Veiculo> veiculos;

    @OneToMany
    private List<Rota> rotas;

}
