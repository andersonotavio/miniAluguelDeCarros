package com.otavioweb.miniAlugelDeCarros.Carros;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carro")
public class CarroController {
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
  @GetMapping("/todos")
  public String allCarros(){
    return "Todos os carros";
  }

  //Mostrar carro por ID (READ)
  @GetMapping("/listar")
  public String mostarCarroPorId(){
    return "Mostando carros";
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
