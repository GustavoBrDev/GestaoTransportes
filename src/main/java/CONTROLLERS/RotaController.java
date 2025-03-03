package CONTROLLERS;

import MODELS.DTO.REQUEST.RotaRequestDTO;
import MODELS.DTO.RESPONSE.FULLRESPONSE.RotaFullResponseDTO;
import SERVICES.RotaService;
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
@RequestMapping("/rotas")
public class RotaController {

    private RotaService service;

    @Tag( name = "Rotas", description = "Gerenciamento de rotas" )
    @Operation (summary = "Cria uma rota", description = "Cria uma rota", tags = {"Rotas"})
    @ApiResponse(responseCode = "201", description = "Rota criada com sucesso", content = @Content( schema = @Schema( implementation = RotaFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"origem\": \" 1\",\n" +
                    "    \"destino\": \" 1\",\n" +
                    "    \"distancia\": 1.0,\n" +
                    "    \"motorista\": {\n" +
                    "        \"id\": 1,\n" +
                    "        \"nome\": \"Motorista 1\",\n" +
                    "        \"telefone\": \"11999999999\",\n" +
                    "        \"email\": \"Bk2Y4@example.com\",\n" +
                    "        \"endereco\": {\n" +
                    "            \"rua\": \"Rua 1\",\n" +
                    "            \"numero\": 1,\n" +
                    "            \"bairro\": \"Bairro 1\",\n" +
                    "            \"cidade\": \"Cidade 1\",\n" +
                    "            \"estado\": \"Estado 1\",\n" +
                    "            \"cep\": \"12345678\"\n" +
                    "        }\n" +
                    "    }\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PostMapping
    public ResponseEntity<RotaFullResponseDTO> criarRota ( @RequestBody @Valid
            @io.swagger.v3.oas.annotations.parameters.RequestBody ( required = true, content = @Content( schema = @Schema( implementation = RotaRequestDTO.class ),
                    examples = @ExampleObject ( value =  "    \"id\": 1,\n" +
                            "    \"origem\": \"1\",\n" +
                            "    \"destino\": \"1\",\n" +
                            "    \"distancia\": 1.0,\n" +
                            "    \"motorista\": {\n" +
                            "        \"id\": 1,\n" +
                            "    }\n" + "}" ))) RotaRequestDTO rotaRequestDTO) {
        try {
            return new ResponseEntity<>(service.criarRota(rotaRequestDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag( name = "Rotas", description = "Gerenciamento de rotas" )
    @Operation (summary = "Atualiza uma rota", description = "Atualiza uma rota", tags = {"Rotas"})
    @ApiResponse(responseCode = "200", description = "Rota atualizada com sucesso", content = @Content( schema = @Schema( implementation = RotaFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"origem\": \"1\",\n" +
                    "    \"destino\": \"1\",\n" +
                    "    \"distancia\": 1.0,\n" +
                    "    \"motorista\": {\n" +
                    "        \"id\": 1,\n" +
                    "        }\n" + "}\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @PutMapping("/{id}")
    public ResponseEntity<RotaFullResponseDTO> atualizarRota (
            @RequestBody  @Valid @io.swagger.v3.oas.annotations.parameters.RequestBody ( required = true, content = @Content( schema = @Schema( implementation = RotaRequestDTO.class ),
                    examples = @ExampleObject ( value =  "    \"id\": 1,\n" +
                            "    \"origem\": \"1\",\n" +
                            "    \"destino\": \"1\",\n" +
                            "    \"distancia\": 1.0,\n" +
                            "    \"motorista\": {\n" +
                            "        \"id\": 1,\n" +
                            "    }\n" + "}" ))) RotaRequestDTO rotaRequestDTO,
            @PathVariable @Positive @NotNull @Parameter ( example = "1", description = "Id da rota", required = true) Integer id) {

        try {
            return new ResponseEntity<>(service.atualizarRota(rotaRequestDTO, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag( name = "Rotas", description = "Gerenciamento de rotas" )
    @Operation (summary = "Busca uma rota", description = "Busca uma rota", tags = {"Rotas"})
    @ApiResponse(responseCode = "200", description = "Rota encontrada com sucesso", content = @Content( schema = @Schema( implementation = RotaFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    "    \"id\": 1,\n" +
                    "    \"origem\": \" 1\",\n" +
                    "    \"destino\": \" 1\",\n" +
                    "    \"distancia\": 1.0,\n" +
                    "    \"motorista\": {\n" +
                    "        \"id\": 1,\n" +
                    "        \"nome\": \"Motorista 1\",\n" +
                    "        \"telefone\": \"11999999999\",\n" +
                    "        \"email\": \"Bk2Y4@example.com\",\n" +
                    "        \"endereco\": {\n" +
                    "            \"rua\": \"Rua 1\",\n" +
                    "            \"numero\": 1,\n" +
                    "            \"bairro\": \"Bairro 1\",\n" +
                    "            \"cidade\": \"Cidade 1\",\n" +
                    "            \"estado\": \"Estado 1\",\n" +
                    "            \"cep\": \"12345678\"\n" +
                    "        }\n" +
                    "    }\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @GetMapping("/{id}")
    public ResponseEntity<RotaFullResponseDTO> buscarRota ( @PathVariable @Positive @NotNull @Parameter ( example = "1", description = "Id da rota", required = true) Integer id) {

        try {
            return new ResponseEntity<>(service.buscarRota(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag( name = "Rotas", description = "Gerenciamento de rotas" )
    @Operation (summary = "Busca todas as rotas", description = "Busca todas as rotas", tags = {"Rotas"})
    @ApiResponse(responseCode = "200", description = "Rotas encontradas com sucesso", content = @Content( schema = @Schema( implementation = RotaFullResponseDTO.class ),
            examples = @ExampleObject( value = "{\n" +
                    " \"id\": 1,\n" +
                    "    \"origem\": \" 1\",\n" +
                    "    \"destino\": \" 1\",\n" +
                    "    \"distancia\": 1.0,\n" +
                    "    \"motorista\": {\n" +
                    "        \"id\": 1,\n" +
                    "        \"nome\": \"Motorista 1\",\n" +
                    "        \"telefone\": \"11999999999\",\n" +
                    "        \"email\": \"Bk2Y4@example.com\",\n" +
                    "        \"endereco\": {\n" +
                    "            \"rua\": \"Rua 1\",\n" +
                    "            \"numero\": 1,\n" +
                    "            \"bairro\": \"Bairro 1\",\n" +
                    "            \"cidade\": \"Cidade 1\",\n" +
                    "            \"estado\": \"Estado 1\",\n" +
                    "            \"cep\": \"12345678\"\n" +
                    "        }\n" +
                    "    }\n" + "}")))
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    @GetMapping
    public ResponseEntity<Page<RotaFullResponseDTO>> buscarTodasRotas ( @PageableDefault ( size = 10, page = 0, direction = Sort.Direction.ASC) Pageable pageable) {

        try {
            return new ResponseEntity<>(service.buscarTodasRotas(pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Tag( name = "Rotas", description = "Gerenciamento de rotas" )
    @Operation (summary = "Deleta uma rota", description = "Deleta uma rota", tags = {"Rotas"})
    @ApiResponse(responseCode = "200", description = "Rota deletada com sucesso")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")
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
