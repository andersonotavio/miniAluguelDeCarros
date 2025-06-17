package com.otavioweb.miniAlugelDeCarros.Carros;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("carro")
public class CarroController {
  private CarroService carroService;

  public CarroController(CarroService carroService) {
    this.carroService = carroService;
  }

  @GetMapping("/")
  public String welcome(){
    return "Welcome my app";
  }

  //Adicionar carro (CREATE)
  @PostMapping("/adicionar")
  public CarroDTO adicionarCarro(@RequestBody CarroDTO carro){
    return carroService.adicionarCarro(carro);
  }
  
  //Mostrar todos os carros (READ)
  @GetMapping("/listar")
  public List<CarroDTO> listarCarros(){
    return carroService.listarCarros();
  }

  //Mostrar carro por ID (READ)
  @GetMapping("/listar/{id}")
  public CarroDTO mostarCarroPorId(@PathVariable Long id){
    return carroService.listarCarroPorId(id);
  }

  //Atualizar carro (UPDATE)
  @PutMapping("/alterar/{id}")
  public CarroDTO alterarCarroPorId(@PathVariable Long id, @RequestBody CarroDTO carroAtualizado){
    return carroService.atualizarCarro(id, carroAtualizado);

  }

  //Deletar carro (DELETE)
  @DeleteMapping("/deletar/{id}")
  public String deletarCarroPorId(@PathVariable Long id){
    carroService.deletarCarro(id);
    return "Carro deletado";
  }
}
