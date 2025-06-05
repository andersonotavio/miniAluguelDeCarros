package com.otavioweb.miniAlugelDeCarros.Carros;

import org.springframework.web.bind.annotation.*;

@RestController
public class CarroController {
  @GetMapping("/")
  public String welcome(){
    return "Welcome my app";
  }

  //Adicionar carro (CREATE)
  @PostMapping("/adicionar-carro")
  public String adicionar(){
    return "Carro adicionado";
  }
  
  //Mostrar todos os carros (READ)
  @GetMapping("/carros")
  public String allCarros(){
    return "Todos os carros";
  }

  //Mostrar carro por ID (READ)
  @GetMapping("/carro")
  public String mostarCarroPorId(){
    return "Mostar carro por Id";
  }

  //Atualizar carro (UPDATE)
  @PutMapping("/alterar-carro")
  public String alterarCarroPorId(){
    return "Alterar carro por Id";
  }

  //Deletar carro (DELETE)
  @DeleteMapping("/deletar-carro")
  public String deletarCarroPorId(){
    return "Deletar carro por Id";
  }
}
