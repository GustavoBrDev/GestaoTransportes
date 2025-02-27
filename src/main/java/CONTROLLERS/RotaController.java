package CONTROLLERS;

import MODELS.DTO.REQUEST.RotaRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.RotaFullResponseDTO;
import SERVICES.RotaService;
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
@RequestMapping("/rotas")
public class RotaController {

    private RotaService service;

    @PostMapping
    public ResponseEntity<RotaFullResponseDTO> criarRota ( @RequestBody @Valid RotaRequestDTO rotaRequestDTO) {

        try {
            return new ResponseEntity<>(service.criarRota(rotaRequestDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<RotaFullResponseDTO> atualizarRota ( @RequestBody @Valid RotaRequestDTO rotaRequestDTO, @PathVariable @Positive @NotNull Integer id) {

        try {
            return new ResponseEntity<>(service.atualizarRota(rotaRequestDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<RotaFullResponseDTO> buscarRota ( @PathVariable @Positive @NotNull Integer id) {

        try {
            return new ResponseEntity<>(service.buscarRota(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Page<RotaFullResponseDTO>> buscarTodasRotas ( @PageableDefault ( size = 10, page = 0, direction = Sort.Direction.ASC) Pageable pageable) {

        try {
            return new ResponseEntity<>(service.buscarTodasRotas(pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarRota ( @PathVariable @Positive @NotNull Integer id) {

        try {
            service.deletarRota(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
