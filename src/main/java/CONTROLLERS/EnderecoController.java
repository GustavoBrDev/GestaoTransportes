package CONTROLLERS;

import MODELS.DTO.REQUEST.EnderecoRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.EnderecoFullResponseDTO;
import SERVICES.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    @Tag( name = "Endereços", description = "Gerenciamento de endereços" )
    @Operation (summary = "Cria um endereço", description = "Cria um endereço" )
    @ApiResponse(responseCode = "201", description = "Endereço criado com sucesso", content = @Content( schema = @Schema( implementation = EnderecoFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"rua\": \"Rua 1\",\n" +
                    "    \"numero\": 1,\n" +
                    "    \"bairro\": \"Bairro 1\",\n" +
                    "    \"cidade\": \"Cidade 1\",\n" +
                    "    \"estado\": \"Estado 1\",\n" +
                    "    \"cep\": \"12345678\"\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PostMapping
    public ResponseEntity<EnderecoFullResponseDTO> criarEndereco (
            @RequestBody @Valid @io.swagger.v3.oas.annotations.parameters.RequestBody ( description = "Endereço a ser criado", required = true,
                    content = @Content ( schema = @Schema ( implementation = EnderecoRequestDTO.class ), examples = @ExampleObject ( value =
                            "{\n" +
                                    "    \"rua\": \"Rua 1\",\n" +
                                    "    \"numero\": 1,\n" +
                                    "    \"bairro\": \"Bairro 1\",\n" +
                                    "    \"cidade\": \"Cidade 1\",\n" +
                                    "    \"estado\": \"Estado 1\",\n" +
                                    "    \"cep\": \"12345678\"\n" + "}") )) EnderecoRequestDTO enderecoRequestDTO) {
        try {
            EnderecoFullResponseDTO endereco = service.criarEndereco(enderecoRequestDTO);
            return new ResponseEntity<>(endereco, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag( name = "Endereços", description = "Gerenciamento de endereços" )
    @Operation (summary = "Atualiza um endereço", description = "Atualiza um endereço" )
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso", content = @Content( schema = @Schema( implementation = EnderecoFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"rua\": \"Rua 1\",\n" +
                    "    \"numero\": 1,\n" +
                    "    \"bairro\": \"Bairro 1\",\n" +
                    "    \"cidade\": \"Cidade 1\",\n" +
                    "    \"estado\": \"Estado 1\",\n" +
                    "    \"cep\": \"12345678\"\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoFullResponseDTO> atualizarEndereco (
            @RequestBody @Valid @io.swagger.v3.oas.annotations.parameters.RequestBody ( description = "Endereço a ser criado", required = true,
                    content = @Content ( schema = @Schema ( implementation = EnderecoRequestDTO.class ), examples = @ExampleObject ( value =
                            "{\n" +
                                    "    \"rua\": \"Rua 1\",\n" +
                                    "    \"numero\": 1,\n" +
                                    "    \"bairro\": \"Bairro 1\",\n" +
                                    "    \"cidade\": \"Cidade 1\",\n" +
                                    "    \"estado\": \"Estado 1\",\n" +
                                    "    \"cep\": \"12345678\"\n" + "}") )) EnderecoRequestDTO enderecoRequestDTO,
            @PathVariable @Positive @NotNull @Parameter ( description = "Id do endereço a ser atualizado", example = "1", required = true ) Integer id) {

        try {
            EnderecoFullResponseDTO endereco = service.atualizarEndereco(enderecoRequestDTO, id);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag( name = "Endereços", description = "Gerenciamento de endereços" )
    @Operation (summary = "Busca um endereço", description = "Busca um endereço" )
    @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso", content = @Content( schema = @Schema( implementation = EnderecoFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"rua\": \"Rua 1\",\n" +
                    "    \"numero\": 1,\n" +
                    "    \"bairro\": \"Bairro 1\",\n" +
                    "    \"cidade\": \"Cidade 1\",\n" +
                    "    \"estado\": \"Estado 1\",\n" +
                    "    \"cep\": \"12345678\"\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoFullResponseDTO> buscarEndereco ( @PathVariable @Positive @NotNull @Parameter ( example = "1", required = true, description = "ID do endereço") Integer id) {

        try {
            EnderecoFullResponseDTO endereco = service.buscarEndereco(id);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag( name = "Endereços", description = "Gerenciamento de endereços" )
    @Operation (summary = "Busca todos os endereços", description = "Busca todos os endereços" )
    @ApiResponse(responseCode = "200", description = "Endereço encontrado com sucesso", content = @Content( schema = @Schema( implementation = EnderecoFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"rua\": \"Rua 1\",\n" +
                    "    \"numero\": 1,\n" +
                    "    \"bairro\": \"Bairro 1\",\n" +
                    "    \"cidade\": \"Cidade 1\",\n" +
                    "    \"estado\": \"Estado 1\",\n" +
                    "    \"cep\": \"12345678\"\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @GetMapping
    public ResponseEntity<Page<EnderecoFullResponseDTO>> buscarTodosEnderecos ( @PageableDefault ( size = 10, page = 0, direction = Sort.Direction.ASC) Pageable pageable ) {

        try {
            Page<EnderecoFullResponseDTO> enderecos = service.buscarTodosEnderecos(pageable);
            return new ResponseEntity<>(enderecos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag( name = "Endereços", description = "Gerenciamento de endereços" )
    @Operation (summary = "Deleta um endereço", description = "Deleta um endereço" )
    @ApiResponse(responseCode = "200", description = "Endereço deletado com sucesso")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco ( @PathVariable @Positive @NotNull @Parameter ( example = "1", required = true, description = "ID do endereço") Integer id) {

        try {
            service.deletarEndereco(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>( HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
