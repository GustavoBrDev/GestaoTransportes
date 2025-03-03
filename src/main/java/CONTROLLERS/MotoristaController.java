package CONTROLLERS;

import MODELS.DTO.REQUEST.MotoristaRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.MotoristaFullResponseDTO;
import SERVICES.MotoristaService;
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
@RequestMapping("/motoristas")
public class MotoristaController {

    private MotoristaService service;

    @Tag(name = "Motoristas", description = "Gerenciamento de motoristas")
    @Operation(summary = "Cria um motorista", description = "Cria um motorista", tags = {"Motoristas"})
    @ApiResponse(responseCode = "201", description = "Motorista criado com sucesso",
        content = @Content ( schema = @Schema ( implementation = MotoristaFullResponseDTO.class ),
        examples = @ExampleObject (value = "{\n" +
                "    \"id\": 1,\n" +
                "    \"nome\": \"João\",\n" +
                "    \"telefone\": \"11999999999\",\n" +
                "    \"email\": \"Bk2Y4@example.com\",\n" +
                "    \"endereco\": {\n" +
                "        \"id\": 1,\n" +
                "        \"rua\": \"Rua 1\",\n" +
                "        \"numero\": 1,\n" +
                "        \"bairro\": \"Bairro 1\",\n" +
                "        \"cidade\": \"Cidade 1\",\n" +
                "        \"estado\": \"Estado 1\",\n" +
                "        \"cep\": \"12345678\"\n" +
                "    }\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PostMapping
    public ResponseEntity<MotoristaFullResponseDTO> criarMotorista (
            @io.swagger.v3.oas.annotations.parameters.RequestBody ( description = "Motorista a ser criado", required = true, content = @Content ( schema = @Schema ( implementation = MotoristaRequestDTO.class ), examples = @ExampleObject ( value =  "\"nome\": \"João\",\n" +
                    "    \"telefone\": \"11999999999\",\n" +
                    "    \"email\": \"Bk2Y4@example.com\",\n" +
                    "    \"endereco\": {\n" +
                    "        \"id\": 1,\n" +
                    "        \"rua\": \"Rua 1\",\n" +
                    "        \"numero\": 1,\n" +
                    "        \"bairro\": \"Bairro 1\",\n" +
                    "        \"cidade\": \"Cidade 1\",\n" +
                    "        \"estado\": \"Estado 1\",\n" +
                    "        \"cep\": \"12345678\"\n" +
                    "    }\n" + "}") ) )
            @RequestBody @Valid MotoristaRequestDTO motorista) {

        try {
            return new ResponseEntity<>(service.criarMotorista(motorista), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag(name = "Motoristas", description = "Gerenciamento de motoristas")
    @Operation(summary = "Atualiza um motorista", description = "Atualiza um motorista", tags = {"Motoristas"})
    @ApiResponse(responseCode = "200", description = "Motorista atualizado com sucesso",
        content = @Content ( schema = @Schema ( implementation = MotoristaFullResponseDTO.class ),
        examples = @ExampleObject (value = "{\n" +
                "    \"id\": 1,\n" +
                "    \"nome\": \"João\",\n" +
                "    \"telefone\": \"11999999999\",\n" +
                "    \"email\": \"Bk2Y4@example.com\",\n" +
                "    \"endereco\": {\n" +
                "        \"id\": 1,\n" +
                "        \"rua\": \"Rua 1\",\n" +
                "        \"numero\": 1,\n" +
                "        \"bairro\": \"Bairro 1\",\n" +
                "        \"cidade\": \"Cidade 1\",\n" +
                "        \"estado\": \"Estado 1\",\n" +
                "        \"cep\": \"12345678\"\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PutMapping("/{id}")
    public ResponseEntity<MotoristaFullResponseDTO> atualizarMotorista (
            @RequestBody @Valid @io.swagger.v3.oas.annotations.parameters.RequestBody ( description = "Motorista a ser atualizado", content = @Content ( schema = @Schema ( implementation = MotoristaRequestDTO.class ), examples = @ExampleObject ( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"nome\": \"João\",\n" +
                    "    \"telefone\": \"11999999999\",\n" +
                    "    \"email\": \"Bk2Y4@example.com\",\n" +
                    "    \"endereco\": {\n" +
                    "        \"id\": 1,\n" +
                    "        \"rua\": \"Rua 1\",\n" +
                    "        \"numero\": 1,\n" +
                    "        \"bairro\": \"Bairro 1\",\n" +
                    "        \"cidade\": \"Cidade 1\",\n" +
                    "        \"estado\": \"Estado 1\",\n" +
                    "        \"cep\": \"12345678\"\n" + "}"))) MotoristaRequestDTO motorista,
            @PathVariable @Positive @Parameter( example = "1", required = true, description = "ID do motorista") @NotNull Integer id) {

        try {
            return new ResponseEntity<>(service.atualizarMotorista(motorista, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @Tag(name = "Motoristas", description = "Gerenciamento de motoristas")
    @Operation(summary = "Busca um motorista", description = "Busca um motorista", tags = {"Motoristas"})
    @ApiResponse(responseCode = "200", description = "Motorista encontrado com sucesso",
        content = @Content ( schema = @Schema ( implementation = MotoristaFullResponseDTO.class ),
        examples = @ExampleObject (value = "{\n" +
                "    \"id\": 1,\n" +
                "    \"nome\": \"João\",\n" +
                "    \"telefone\": \"11999999999\",\n" +
                "    \"email\": \"Bk2Y4@example.com\",\n" +
                "    \"endereco\": {\n" +
                "        \"id\": 1,\n" +
                "        \"rua\": \"Rua 1\",\n" +
                "        \"numero\": 1,\n" +
                "        \"bairro\": \"Bairro 1\",\n" +
                "        \"cidade\": \"Cidade 1\",\n" +
                "        \"estado\": \"Estado 1\",\n" +
                "        \"cep\": \"12345678\"\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<MotoristaFullResponseDTO> buscarMotorista ( @PathVariable @Positive @NotNull@Parameter( example = "1", required = true, description = "ID do motorista") Integer id) {

        try {
            return new ResponseEntity<>(service.buscarMotorista(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    @Tag(name = "Motoristas", description = "Gerenciamento de motoristas")
    @Operation(summary = "Busca todos os motoristas", description = "Busca todos os motoristas", tags = {"Motoristas"})
    @ApiResponse(responseCode = "200", description = "Motoristas encontrados com sucesso",
        content = @Content ( schema = @Schema ( implementation = MotoristaFullResponseDTO.class ),
        examples = @ExampleObject (value = "{\n" +
                "    \"id\": 1,\n" +
                "    \"nome\": \"João\",\n" +
                "    \"telefone\": \"11999999999\",\n" +
                "    \"email\": \"Bk2Y4@example.com\",\n" +
                "    \"endereco\": {\n" +
                "        \"id\": 1,\n" +
                "        \"rua\": \"Rua 1\",\n" +
                "        \"numero\": 1,\n" +
                "        \"bairro\": \"Bairro 1\",\n" +
                "        \"cidade\": \"Cidade 1\",\n" +
                "        \"estado\": \"Estado 1\",\n" +
                "        \"cep\": \"12345678\"\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    public ResponseEntity<Page<MotoristaFullResponseDTO>> buscarTodosMotoristas (@PageableDefault(size = 10, page = 0, direction = Sort.Direction.ASC) Pageable pageable) {

        try {
            return new ResponseEntity<>(service.buscarTodosMotoristas(pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag(name = "Motoristas", description = "Gerenciamento de motoristas")
    @Operation(summary = "Deleta um motorista", description = "Deleta um motorista", tags = {"Motoristas"})
    @ApiResponse(responseCode = "200", description = "Motorista deletado com sucesso")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMotorista ( @PathVariable @Positive @NotNull @Parameter ( example = "1", required = true, description = "ID do motorista") Integer id) {

        try {
            service.deletarMotorista(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
