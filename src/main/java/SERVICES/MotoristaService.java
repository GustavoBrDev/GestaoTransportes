package SERVICES;

import MODELS.DTO.REQUEST.MotoristaRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.MotoristaFullResponseDTO;
import MODELS.ENTITY.Motorista;
import MODELS.EXCEPTIONS.DadosInvalidosException;
import MODELS.EXCEPTIONS.NaoEncontradoException;
import REPOSITORY.MotoristaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@AllArgsConstructor
@Service
public class MotoristaService {

    private MotoristaRepository repository;

    public MotoristaFullResponseDTO criarMotorista (MotoristaRequestDTO motoristaRequestDTO) {

        try {

            Motorista motorista = motoristaRequestDTO.converter();

            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(motorista.getEmail());

            if (!matcher.matches()) {
                throw new DadosInvalidosException("Email inválido");
            }

            return repository.save(motorista).converter();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar motorista: " + e.getMessage());
        }
    }

    public MotoristaFullResponseDTO buscarMotorista (Integer id) {

        try {
            if ( repository.existsById(id) ) {
                return repository.findById(id).get().converter();
            } else {
                throw new NaoEncontradoException("Motorista não encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar motorista: " + e.getMessage());
        }
    }

    public Page<MotoristaFullResponseDTO> buscarTodosMotoristas (Pageable pageable) {

        try {
            return repository.findAll(pageable).map(Motorista::converter);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos motoristas: " + e.getMessage());
        }
    }

    public MotoristaFullResponseDTO atualizarMotorista (MotoristaRequestDTO motoristaRequestDTO, Integer id) {

        try {
            if ( repository.existsById(id) ) {
                return this.criarMotorista(motoristaRequestDTO);
            } else {
                throw new NaoEncontradoException("Motorista não encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar motorista: " + e.getMessage());
        }
    }

    public void deletarMotorista (Integer id) {

        try {
            if ( repository.existsById(id) ) {
                repository.deleteById(id);
            } else {
                throw new NaoEncontradoException("Motorista não encontrado");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar motorista: " + e.getMessage());
        }
    }
}
