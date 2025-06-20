package com.otavioweb.miniAlugelDeCarros.Carros;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carro")
public class CarroController {
  private final CarroService carroService;

  public CarroController(CarroService carroService) {
    this.carroService = carroService;
  }

  @GetMapping("/")
  @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
  public String welcome(){
    return "Welcome my app";
  }


  @PostMapping("/adicionar")
  @Operation(summary = "Adiciona um novo carro", description = "Rota adiciona um novo carro e insere no banco de dados")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Carro adicionado com sucesso"),
          @ApiResponse(responseCode = "400", description = "Erro na adição do novo carro")
  })
  public ResponseEntity<String> adicionarCarro(@RequestBody CarroDTO carro){

    CarroDTO novoCarro = carroService.adicionarCarro(carro);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Carro adicionado com sucesso " + novoCarro.getModelo() + " (ID): " + novoCarro.getId());
  }


  @GetMapping("/listar")
  @Operation(summary = "Lista todos carros", description = "Rota lista todos os carros no banco de dados")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Carros listados"),
          @ApiResponse(responseCode = "404", description = "Rota não encontrada")
  })
  public ResponseEntity<List<CarroDTO>> listarCarros(){
    List<CarroDTO> carros = carroService.listarCarros();
    return ResponseEntity.ok(carros);
  }

  @GetMapping("/listar/{id}")
  @Operation(summary = "Lista o carro por ID", description = "Rota lista um carro por ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Carro listado"),
          @ApiResponse(responseCode = "404", description = "Carro não encontrado")
  })
  public ResponseEntity<?> mostarCarroPorId(@PathVariable Long id){

    if(carroService.listarCarroPorId(id) != null){
     CarroDTO carro = carroService.listarCarroPorId(id);
      return ResponseEntity.ok(carro);
    }else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Carro com ID: " + id + " não encontrado");
    }
  }


  @PutMapping("/alterar/{id}")
  @Operation(summary = "Alterar os dados do carro", description = "Rota altera os dados do carro por ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Carros alterado"),
          @ApiResponse(responseCode = "404", description = "Carro não encontrado")
  })
  public ResponseEntity<?> alterarCarroPorId(@PathVariable Long id, @RequestBody CarroDTO carro){
    if(carroService.listarCarroPorId(id) != null ){
      CarroDTO carroAtualizado = carroService.atualizarCarro(id, carro);
      return ResponseEntity.ok(carroAtualizado);
    }else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Carro de ID: " +id+ " não encontrado");
    }

  }

  //Deletar carro (DELETE)
  @DeleteMapping("/deletar/{id}")
  @Operation(summary = "Deletar carro", description = "Rota deleta um carro")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Carros deletado"),
          @ApiResponse(responseCode = "400", description = "Erro ao deletar carro")
  })
  public ResponseEntity<String> deletarCarroPorId(@PathVariable Long id){
      if(carroService.listarCarroPorId(id) != null){
        carroService.deletarCarro(id);
        return ResponseEntity.ok("Carro de ID: " +id+ " deletado com sucesso");
      }else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("O carro de id " +id+ " não foi encontrado");
      }
  }
}
