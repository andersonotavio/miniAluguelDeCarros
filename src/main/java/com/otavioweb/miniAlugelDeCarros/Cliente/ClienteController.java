package com.otavioweb.miniAlugelDeCarros.Cliente;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {
  private ClienteService clienteService;

  public ClienteController(ClienteService clienteService) {
    this.clienteService = clienteService;
  }

  //Adicionar cliente (CREATE)
  @PostMapping("/cadastrar")
  public ClienteDTO cadastrarCliente(@RequestBody ClienteDTO cliente){
    return clienteService.cadastrarCliente(cliente);
  }

  //Mostrar todos os cliente (READ)
  @GetMapping("/listar")
  public List<ClienteDTO> listarClientes(){
    return clienteService.listarClientes();
  }

  //Mostrar cliente por ID (READ)
  @GetMapping("/listar/{id}")
  public ClienteDTO mostarClientePorId(@PathVariable Long id){
    return clienteService.listarClientePorId(id);
  }

  //Atualizar cliente (UPDATE)
  @PutMapping("/atualizar/{id}")
  public ClienteDTO alterarClientePorId(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){

    return clienteService.atualizarCliente(id, clienteDTO);
  }

  //Deletar cliente (DELETE)
  @DeleteMapping("/deletar/{id}")
  public String deletarClientePorId(@PathVariable Long id){
    clienteService.deletarCliente(id);
    return "Cliente deletado";
  }
}
