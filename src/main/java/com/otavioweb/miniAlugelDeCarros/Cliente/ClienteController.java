package com.otavioweb.miniAlugelDeCarros.Cliente;

import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {


  //Adicionar cliente (CREATE)
  @PostMapping("/adicionar-cliente")
  public String adicionar(){
    return "Carro adicionado";
  }

  //Mostrar todos os cliente (READ)
  @GetMapping("/clientes")
  public String allClientes(){
    return "Todos os carros";
  }

  //Mostrar cliente por ID (READ)
  @GetMapping("/cliente")
  public String mostarClientePorId(){
    return "Mostar carro por Id";
  }

  //Atualizar cliente (UPDATE)
  @PutMapping("/alterar-cliente")
  public String alterarClientePorId(){
    return "Alterar carro por Id";
  }

  //Deletar cliente (DELETE)
  @DeleteMapping("deletar-cliente")
  public String deletarClientePorId(){
    return "Deletar carro por Id";
  }
}
