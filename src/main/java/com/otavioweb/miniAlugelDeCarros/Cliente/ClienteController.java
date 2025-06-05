package com.otavioweb.miniAlugelDeCarros.Cliente;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cliente")
public class ClienteController {


  //Adicionar cliente (CREATE)
  @PostMapping("/adicionar")
  public String adicionarCliente(){
    return "Cliente adicionado";
  }

  //Mostrar todos os cliente (READ)
  @GetMapping("/todos")
  public String allClientes(){
    return "Todos os clientes";
  }

  //Mostrar cliente por ID (READ)
  @GetMapping("/listar")
  public String mostarClientePorId(){
    return "Mostar cliente por Id";
  }

  //Atualizar cliente (UPDATE)
  @PutMapping("/alterar")
  public String alterarClientePorId(){
    return "Alterado";
  }

  //Deletar cliente (DELETE)
  @DeleteMapping("/deletar")
  public String deletarClientePorId(){
    return "Deletado";
  }
}
