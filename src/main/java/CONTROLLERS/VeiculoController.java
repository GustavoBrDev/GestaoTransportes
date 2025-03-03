package CONTROLLERS;

import MODELS.DTO.REQUEST.VeiculoRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.VeiculoFullResponseDTO;
import SERVICES.VeiculoService;
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
@RequestMapping("/veiculos")
public class VeiculoController {

    private VeiculoService service;

    @Tag(name = "Veículos", description = "Gerenciamento de veículos")
    @Operation(summary = "Cria um veículo", description = "Cria um veículo", tags = {"Veículos"})
    @ApiResponse(responseCode = "201", description = "Veículo criado com sucesso", content = @Content( schema = @Schema( implementation = VeiculoFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"placa\": \"ABC-1234\",\n" +
                    "    \"modelo\": \"Modelo 1\",\n" +
                    "    \"marca\": \"Marca 1\",\n" +
                    "    \"motorista\": {\n" +
                    "        \"id\": 1,\n" +
                    "        \"nome\": \"João\",\n" +
                    "        \"telefone\": \"11999999999\",\n" +
                    "        \"email\": \"Bk2Y4@example.com\",\n" +
                    "        \"endereco\": {\n" +
                    "            \"id\": 1,\n" +
                    "            \"rua\": \"Rua 1\",\n" +
                    "            \"numero\": 1,\n" +
                    "            \"bairro\": \"Bairro 1\",\n" +
                    "            \"cidade\": \"Cidade 1\",\n" +
                    "            \"estado\": \"Estado 1\",\n" +
                    "            \"cep\": \"12345678\"\n" +
                    "        }\n" + "}\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PostMapping
    public ResponseEntity<VeiculoFullResponseDTO> criarVeiculo (@RequestBody @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody (required = true, description = "Veículo a ser criado", content = @Content( schema = @Schema( implementation = VeiculoRequestDTO.class ),
                    examples = @ExampleObject( value = "{\n" + "    \"placa\": \"ABC-1234\",\n" + "    \"modelo\": \"Modelo 1\",\n" + "    \"marca\": \"Marca 1\",\n" + "    \"motoristaId\": 1\n" + "}" ) )) VeiculoRequestDTO veiculoRequestDTO) {

        try {
            return new ResponseEntity<>(service.criarVeiculo(veiculoRequestDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag(name = "Veículos", description = "Gerenciamento de veículos")
    @Operation(summary = "Busca um veículo", description = "Busca um veículo", tags = {"Veículos"})
    @ApiResponse(responseCode = "200", description = "Veículo encontrado com sucesso", content = @Content( schema = @Schema( implementation = VeiculoFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"placa\": \"ABC-1234\",\n" +
                    "    \"modelo\": \"Modelo 1\",\n" +
                    "    \"marca\": \"Marca 1\",\n" +
                    "    \"motorista\": {\n" +
                    "        \"id\": 1,\n" +
                    "        \"nome\": \"João\",\n" +
                    "        \"telefone\": \"11999999999\",\n" +
                    "        \"email\": \"Bk2Y4@example.com\",\n" +
                    "        \"endereco\": {\n" +
                    "            \"id\": 1,\n" +
                    "            \"rua\": \"Rua 1\",\n" +
                    "            \"numero\": 1,\n" +
                    "            \"bairro\": \"Bairro 1\",\n" +
                    "            \"cidade\": \"Cidade 1\",\n" +
                    "            \"estado\": \"Estado 1\",\n" +
                    "            \"cep\": \"12345678\"\n" + "}\n" + "}\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @GetMapping("/{id}")
    public ResponseEntity<VeiculoFullResponseDTO> buscarVeiculo (@PathVariable @Positive @NotNull @Parameter ( description = "ID do veículo", example = "1") Integer id) {

        try {
            return new ResponseEntity<>(service.buscarVeiculo(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag(name = "Veículos", description = "Gerenciamento de veículos")
    @Operation(summary = "Busca todos os veículos", description = "Busca todos os veículos", tags = {"Veículos"})
    @ApiResponse(responseCode = "200", description = "Veículos encontrados com sucesso", content = @Content( schema = @Schema( implementation = VeiculoFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"placa\": \"ABC-1234\",\n" +
                    "    \"modelo\": \"Modelo 1\",\n" +
                    "    \"marca\": \"Marca 1\",\n" +
                    "    \"motorista\": {\n" +
                    "        \"id\": 1,\n" +
                    "        \"nome\": \"João\",\n" +
                    "        \"telefone\": \"11999999999\",\n" +
                    "        \"email\": \"Bk2Y4@example.com\",\n" +
                    "        \"endereco\": {\n" +
                    "            \"id\": 1,\n" +
                    "            \"rua\": \"Rua 1\",\n" +
                    "            \"numero\": 1,\n" +
                    "            \"bairro\": \"Bairro 1\",\n" +
                    "            \"cidade\": \"Cidade 1\",\n" +
                    "            \"estado\": \"Estado 1\",\n" +
                    "            \"cep\": \"12345678\"\n" + "}\n" + "}\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @GetMapping
    public ResponseEntity<Page<VeiculoFullResponseDTO>> buscarTodosVeiculos (@PageableDefault(size = 10, page = 0, direction = Sort.Direction.ASC) Pageable pageable) {

        try {
            return new ResponseEntity<>(service.buscarTodosVeiculos(pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag(name = "Veículos", description = "Gerenciamento de veículos")
    @Operation(summary = "Atualiza um veículo", description = "Atualiza um veículo", tags = {"Veículos"})
    @ApiResponse(responseCode = "200", description = "Veículo atualizado com sucesso", content = @Content( schema = @Schema( implementation = VeiculoFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"placa\": \"ABC-1234\",\n" +
                    "    \"modelo\": \"Modelo 1\",\n" +
                    "    \"marca\": \"Marca 1\",\n" +
                    "    \"motorista\": {\n" +
                    "        \"id\": 1,\n" +
                    "        \"nome\": \"João\",\n" +
                    "        \"telefone\": \"11999999999\",\n" +
                    "        \"email\": \"Bk2Y4@example.com\",\n" +
                    "        \"endereco\": {\n" +
                    "            \"id\": 1,\n" +
                    "            \"rua\": \"Rua 1\",\n" +
                    "            \"numero\": 1,\n" +
                    "            \"bairro\": \"Bairro 1\",\n" +
                    "            \"cidade\": \"Cidade 1\",\n" +
                    "            \"estado\": \"Estado 1\",\n" +
                    "            \"cep\": \"12345678\"\n" + "}\n" + "}\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PutMapping("/{id}")
    public ResponseEntity<VeiculoFullResponseDTO> atualizarVeiculo (
            @RequestBody @Valid @io.swagger.v3.oas.annotations.parameters.RequestBody ( description = "Veículo a ser atualizado", content = @Content( schema = @Schema( implementation = VeiculoRequestDTO.class ),
            examples = @ExampleObject( value = "{\n" + "    \"placa\": \"ABC-1234\",\n" + "    \"modelo\": \"Modelo 1\",\n" + "    \"marca\": \"Marca 1\",\n" + "    \"motoristaId\": 1\n" + "}" ) ) ) VeiculoRequestDTO veiculoRequestDTO,
            @PathVariable @Positive @NotNull @Parameter(description = "ID do veículo a ser atualizado", example = "1", required = true) Integer id) {

        try {
            return new ResponseEntity<>(service.atualizarVeiculo(veiculoRequestDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag(name = "Veículos", description = "Gerenciamento de veículos")
    @Operation(summary = "Deleta um veículo", description = "Deleta um veículo", tags = {"Veículos"})
    @ApiResponse(responseCode = "200", description = "Veículo deletado com sucesso")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo (@PathVariable @Positive @NotNull Integer id) {

        try {
            service.deletarVeiculo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
