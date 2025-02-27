package MODELS.ENTITY;

import MODELS.DTO.RESPONSE.FULLRESPONSE.MotoristaFullResponseDTO;
import MODELS.DTO.RESPONSE.MotoristaRotaResponseDTO;
import MODELS.DTO.RESPONSE.MotoristaVeiculoResponseDTO;
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

    public MotoristaRotaResponseDTO converterSemRotas (){
        return MotoristaRotaResponseDTO.builder()
                .id(id)
                .nome(nome)
                .telefone(telefone)
                .email(email)
                .endereco(endereco.converterSemId())
                .veiculos( veiculos.stream().map(Veiculo::converterSemMotorista).toList())
                .build();
    }

    public MotoristaVeiculoResponseDTO converterSemVeiculo() {
        return MotoristaVeiculoResponseDTO.builder()
                .id(id)
                .nome(nome)
                .telefone(telefone)
                .email(email)
                .endereco(endereco.converterSemId())
                .rotas(rotas.stream().map(Rota::converterSemMotorista).toList())
                .build();
    }

    public MotoristaFullResponseDTO converter() {
        return MotoristaFullResponseDTO.builder()
                .id(id)
                .nome(nome)
                .telefone(telefone)
                .email(email)
                .endereco(endereco.converterSemId())
                .veiculos(veiculos.stream().map(Veiculo::converterSemMotorista).toList())
                .rotas(rotas.stream().map(Rota::converterSemMotorista).toList())
                .build();
    }
}
