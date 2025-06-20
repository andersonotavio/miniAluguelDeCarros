package com.otavioweb.miniAlugelDeCarros.Carros;

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
  public String welcome(){
    return "Welcome my app";
  }

  //Adicionar carro (CREATE)
  @PostMapping("/adicionar")
  public ResponseEntity adicionarCarro(@RequestBody CarroDTO carro){

    CarroDTO novoCarro = carroService.adicionarCarro(carro);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Carro adicionado com sucesso " + novoCarro.getModelo() + " (ID): " + novoCarro.getId());
  }
  
  //Mostrar todos os carros (READ)
  @GetMapping("/listar")
  public ResponseEntity<List<CarroDTO>> listarCarros(){
    List<CarroDTO> carros = carroService.listarCarros();
    return ResponseEntity.ok(carros);
  }

  //Mostrar carro por ID (READ)
  @GetMapping("/listar/{id}")
  public ResponseEntity<?> mostarCarroPorId(@PathVariable Long id){

    if(carroService.listarCarroPorId(id) != null){
     CarroDTO carro = carroService.listarCarroPorId(id);
      return ResponseEntity.ok(carro);
    }else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Carro com ID: " + id + " não encontrado");
    }
  }

  //Atualizar carro (UPDATE)
  @PutMapping("/alterar/{id}")
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
