package SERVICES;

import MODELS.DTO.REQUEST.EnderecoRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.EnderecoFullResponseDTO;
import MODELS.ENTITY.Endereco;
import MODELS.EXCEPTIONS.DadosInvalidosException;
import MODELS.EXCEPTIONS.NaoEncontradoException;
import REPOSITORY.EnderecoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class EnderecoService {

    private EnderecoRepository repository;

    public EnderecoFullResponseDTO criarEndereco (EnderecoRequestDTO enderecoRequestDTO) {

        try {
            Endereco endereco = enderecoRequestDTO.converter();

            String cepRegex = "^\\d{8}$"; // Regex para validar CEP (8 dígitos)
            Pattern pattern = Pattern.compile(cepRegex);
            Matcher matcher = pattern.matcher(endereco.getCep());

            if (!matcher.matches()) {
                throw new DadosInvalidosException("CEP inválido");
            }

            return repository.save(endereco).converter();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar endereço: " + e.getMessage());
        }
    }

    public EnderecoFullResponseDTO buscarEndereco (Integer id) {
        try {

            if ( repository.existsById(id) ) {
                return repository.findById(id).get().converter();
            } else {
                throw new NaoEncontradoException("Endereço não encontrado");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar endereço: " + e.getMessage());
        }
    }

    public Page<EnderecoFullResponseDTO> buscarTodosEnderecos (Pageable pageable ) {

        try {
            return repository.findAll(pageable).map(Endereco::converter);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar todos endereços: " + e.getMessage());
        }
    }

    public EnderecoFullResponseDTO atualizarEndereco (EnderecoRequestDTO enderecoRequestDTO, Integer id) {
        try {

            if ( repository.existsById(id) ) {
                return this.criarEndereco(enderecoRequestDTO);
            } else {
                throw new NaoEncontradoException("Endereço não encontrado");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar endereço: " + e.getMessage());
        }
    }

    public void deletarEndereco (Integer id) {
        try {

            if ( repository.existsById(id) ) {
                repository.deleteById(id);
            } else {
                throw new NaoEncontradoException("Endereço não encontrado");
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar endereço: " + e.getMessage());
        }
    }

}
