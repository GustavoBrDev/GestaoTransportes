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
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private EnderecoService service;

    @PostMapping
    public EnderecoFullResponseDTO criarEndereco ( @RequestBody @Valid EnderecoRequestDTO enderecoRequestDTO) {
        return service.criarEndereco(enderecoRequestDTO);
    }

    @PutMapping
    public EnderecoFullResponseDTO atualizarEndereco ( @RequestBody @Valid EnderecoRequestDTO enderecoRequestDTO, @RequestParam @Positive @NotNull Integer id) {
        return service.atualizarEndereco(enderecoRequestDTO, id);
    }

    @GetMapping("/{id}")
    public EnderecoFullResponseDTO buscarEndereco ( @PathVariable @Positive @NotNull Integer id) {
        return service.buscarEndereco(id);
    }

    @GetMapping
    public Page<EnderecoFullResponseDTO> buscarTodosEnderecos ( @PageableDefault ( size = 10, page = 0, direction = Sort.Direction.ASC) Pageable pageable ) {
        return service.buscarTodosEnderecos(pageable);
    }

    @DeleteMapping
    public void deletarEndereco ( @RequestParam @Positive @NotNull Integer id) {
        service.deletarEndereco(id);
    }
}
