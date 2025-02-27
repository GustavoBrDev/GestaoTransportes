package CONTROLLERS;

import MODELS.DTO.REQUEST.VeiculoRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.VeiculoFullResponseDTO;
import SERVICES.VeiculoService;
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
@RequestMapping("/veiculos")
public class VeiculoController {

    private VeiculoService service;

    @PostMapping
    public ResponseEntity<VeiculoFullResponseDTO> criarVeiculo (@RequestBody @Valid VeiculoRequestDTO veiculoRequestDTO) {

        try {
            return new ResponseEntity<>(service.criarVeiculo(veiculoRequestDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoFullResponseDTO> buscarVeiculo (@PathVariable @Positive @NotNull Integer id) {

        try {
            return new ResponseEntity<>(service.buscarVeiculo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Page<VeiculoFullResponseDTO>> buscarTodosVeiculos (@PageableDefault(size = 10, page = 0, direction = Sort.Direction.ASC) Pageable pageable) {

        try {
            return new ResponseEntity<>(service.buscarTodosVeiculos(pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<VeiculoFullResponseDTO> atualizarVeiculo (@RequestBody @Valid VeiculoRequestDTO veiculoRequestDTO, @PathVariable @Positive @NotNull Integer id) {

        try {
            return new ResponseEntity<>(service.atualizarVeiculo(veiculoRequestDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarVeiculo (@RequestParam @Positive @NotNull Integer id) {

        try {
            service.deletarVeiculo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
