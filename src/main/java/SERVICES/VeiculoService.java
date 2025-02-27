package SERVICES;

import MODELS.DTO.REQUEST.VeiculoRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.VeiculoFullResponseDTO;
import MODELS.ENTITY.Veiculo;
import MODELS.EXCEPTIONS.NaoEncontradoException;
import REPOSITORY.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VeiculoService {

    private VeiculoRepository repository;

    public VeiculoFullResponseDTO criarVeiculo (VeiculoRequestDTO veiculoRequestDTO) {

        try {

            Veiculo veiculo = veiculoRequestDTO.converter();
            return repository.save(veiculo).converter();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar veiculo: " + e.getMessage());
        }

    }

    public VeiculoFullResponseDTO atualizarVeiculo (VeiculoRequestDTO veiculoRequestDTO, Integer id) {

        try {
            if ( repository.existsById(id) ) {
                return this.criarVeiculo(veiculoRequestDTO);
            } else {
                throw new NaoEncontradoException("Veiculo não encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar veiculo: " + e.getMessage());
        }
    }

    public VeiculoFullResponseDTO buscarVeiculo (Integer id) {

        try {
            if ( repository.existsById(id) ) {
                return repository.findById(id).get().converter();
            } else {
                throw new NaoEncontradoException("Veiculo não encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar veiculo: " + e.getMessage());
        }
    }

    public Page<VeiculoFullResponseDTO> buscarTodosVeiculos (Pageable pageable) {

        try {
            return repository.findAll(pageable).map(Veiculo::converter);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos veiculos: " + e.getMessage());
        }
    }

    public void deletarVeiculo (Integer id) {

        try {
            if ( repository.existsById(id) ) {
                repository.deleteById(id);
            } else {
                throw new NaoEncontradoException("Veiculo não encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar veiculo: " + e.getMessage());
        }
    }
}
