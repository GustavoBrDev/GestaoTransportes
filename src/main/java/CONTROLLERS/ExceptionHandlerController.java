package CONTROLLERS;

import MODELS.EXCEPTIONS.DadosInvalidosException;
import MODELS.EXCEPTIONS.ExceptionResponseDTO;
import MODELS.EXCEPTIONS.NaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(DadosInvalidosException.class)
    public ResponseEntity<ExceptionResponseDTO> handleDadosInvalidosException(DadosInvalidosException ex) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO( "Dados inválidos", ex.getMessage(), Instant.now() );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NaoEncontradoException.class)
    public ResponseEntity<ExceptionResponseDTO> handleNaoEncontradoException(NaoEncontradoException ex) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO( "Não encontrado", ex.getMessage(), Instant.now() );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDTO> handleException(Exception ex) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO( "Erro interno", ex.getMessage(), Instant.now() );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
