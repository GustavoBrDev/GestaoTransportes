package CONTROLLERS;

import MODELS.DTO.REQUEST.EnderecoRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.EnderecoFullResponseDTO;
import SERVICES.EnderecoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private EnderecoService service;

    @PostMapping
    public ResponseEntity<EnderecoFullResponseDTO> criarEndereco (@RequestBody @Valid EnderecoRequestDTO enderecoRequestDTO) {

        try {
            EnderecoFullResponseDTO endereco = service.criarEndereco(enderecoRequestDTO);
            return new ResponseEntity<>(endereco, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoFullResponseDTO> atualizarEndereco ( @RequestBody @Valid EnderecoRequestDTO enderecoRequestDTO, @PathVariable @Positive @NotNull Integer id) {

        try {
            EnderecoFullResponseDTO endereco = service.atualizarEndereco(enderecoRequestDTO, id);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoFullResponseDTO> buscarEndereco ( @PathVariable @Positive @NotNull Integer id) {

        try {
            EnderecoFullResponseDTO endereco = service.buscarEndereco(id);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Page<EnderecoFullResponseDTO>> buscarTodosEnderecos ( @PageableDefault ( size = 10, page = 0, direction = Sort.Direction.ASC) Pageable pageable ) {

        try {
            Page<EnderecoFullResponseDTO> enderecos = service.buscarTodosEnderecos(pageable);
            return new ResponseEntity<>(enderecos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco ( @PathVariable @Positive @NotNull Integer id) {

        try {
            service.deletarEndereco(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
