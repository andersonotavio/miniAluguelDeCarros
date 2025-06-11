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
  public String adicionar(){
    return "Carro adicionado";
  }
  
  //Mostrar todos os carros (READ)
  @GetMapping("/listar")
  public List<CarroModel> listarCarros(){
    return carroService.listarCarros();
  }

  //Mostrar carro por ID (READ)
  @GetMapping("/listar/{id}")
  public CarroModel mostarCarroPorId(@PathVariable Long id){
    return carroService.listarCarroPorId(id);
  }

  //Atualizar carro (UPDATE)
  @PutMapping("/alterar")
  public String alterarCarroPorId(){
    return "Alterado";
  }

  //Deletar carro (DELETE)
  @DeleteMapping("/deletar")
  public String deletarCarroPorId(){
    return "Carro deletado";
  }
}
