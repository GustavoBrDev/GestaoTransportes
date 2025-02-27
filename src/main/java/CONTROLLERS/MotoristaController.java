package CONTROLLERS;

import MODELS.DTO.REQUEST.MotoristaRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.MotoristaFullResponseDTO;
import SERVICES.MotoristaService;
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
@RequestMapping("/motoristas")
public class MotoristaController {

    private MotoristaService service;

    @PostMapping
    public ResponseEntity<MotoristaFullResponseDTO> criarMotorista ( @RequestBody @Valid MotoristaRequestDTO motorista) {

        try {
            return new ResponseEntity<>(service.criarMotorista(motorista), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotoristaFullResponseDTO> atualizarMotorista ( @RequestBody @Valid MotoristaRequestDTO motorista, @PathVariable @Positive @NotNull Integer id) {

        try {
            return new ResponseEntity<>(service.atualizarMotorista(motorista, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaFullResponseDTO> buscarMotorista ( @PathVariable @Positive @NotNull Integer id) {

        try {
            return new ResponseEntity<>(service.buscarMotorista(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Page<MotoristaFullResponseDTO>> buscarTodosMotoristas (@PageableDefault(size = 10, page = 0, direction = Sort.Direction.ASC) Pageable pageable) {

        try {
            return new ResponseEntity<>(service.buscarTodosMotoristas(pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMotorista ( @PathVariable @Positive @NotNull Integer id) {

        try {
            service.deletarMotorista(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
