package SERVICES;

import MODELS.DTO.REQUEST.RotaRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.RotaFullResponseDTO;
import MODELS.ENTITY.Rota;
import MODELS.EXCEPTIONS.NaoEncontradoException;
import REPOSITORY.RotaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RotaService {

    private RotaRepository repository;

    public RotaFullResponseDTO criarRota (RotaRequestDTO rotaRequestDTO) {

        try {
            Rota rota = rotaRequestDTO.converter();
            return repository.save(rota).converter();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar rota: " + e.getMessage());
        }
    }

    public RotaFullResponseDTO atualizarRota (RotaRequestDTO rotaRequestDTO, Integer id) {

        try {
            if ( repository.existsById(id) ) {
                Rota rota = rotaRequestDTO.converter();
                rota.setId(id);
                return repository.save(rota).converter();
            } else {
                throw new NaoEncontradoException("Rota não encontrada");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar rota: " + e.getMessage());
        }
    }

    public RotaFullResponseDTO buscarRota (Integer id) {

        try {
            if ( repository.existsById(id) ) {
                return repository.findById(id).get().converter();
            } else {
                throw new NaoEncontradoException("Rota não encontrada");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar rota: " + e.getMessage());
        }
    }

    public Page<RotaFullResponseDTO> buscarTodasRotas (Pageable pageable ) {
        try {
            return repository.findAll(pageable).map(Rota::converter);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todas rotas: " + e.getMessage());
        }
    }

    public void deletarRota (Integer id) {

        try {
            if ( repository.existsById(id) ) {
                repository.deleteById(id);
            } else {
                throw new NaoEncontradoException("Rota não encontrada");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar rota: " + e.getMessage());
        }
    }
}
