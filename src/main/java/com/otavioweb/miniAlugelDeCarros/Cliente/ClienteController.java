package com.otavioweb.miniAlugelDeCarros.Cliente;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class ClienteController {
  private final ClienteService clienteService;

  public ClienteController(ClienteService clienteService) {
    this.clienteService = clienteService;
  }


  @PostMapping("/cadastrar")
  @Operation(summary = "Cadastra um novo cliente", description = "Rota cadastra um novo cliente e insere no banco de dados")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso"),
          @ApiResponse(responseCode = "400", description = "Erro ao cadastrar novo cliente")
  })
  public ResponseEntity<String> cadastrarCliente(@RequestBody ClienteDTO cliente){
    ClienteDTO novoCliente = clienteService.cadastrarCliente(cliente);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Novo cliente: " +novoCliente.getNome());
  }


  @GetMapping("/listar")
  @Operation(summary = "Lista todos clientes", description = "Rota lista todos os clientes no banco de dados")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Clientes listados"),
          @ApiResponse(responseCode = "404", description = "Rota não encontrada")
  })
  public ResponseEntity<List<ClienteDTO>> listarClientes(){
    List<ClienteDTO> clientes = clienteService.listarClientes();
    return ResponseEntity.ok(clientes);
  }


  @GetMapping("/listar/{id}")
  @Operation(summary = "Lista o cliente por ID", description = "Rota lista um cliente por ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Cliente listado"),
          @ApiResponse(responseCode = "404", description = "Cliente não encontrado")
  })
  public ResponseEntity<?> mostarClientePorId(@PathVariable Long id){
    ClienteDTO cliente = clienteService.listarClientePorId(id);
    if(cliente != null){
      return ResponseEntity.ok(cliente);
    }else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Cliente de ID: " +id+ "não encontrado");
    }
  }

  @PutMapping("/atualizar/{id}")
  @Operation(summary = "Alterar os dados do cliente", description = "Rota altera os dados do cliente por ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Cliente alterado"),
          @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
          @ApiResponse(responseCode = "400", description = "Erro ao atualizar cliente")
  })
  public ResponseEntity<?> alterarClientePorId(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
    ClienteDTO clienteAtualizado = clienteService.atualizarCliente(id, clienteDTO);
    if(clienteAtualizado != null){
      return ResponseEntity.ok(clienteAtualizado);
    }else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Erro ao atualizar cliente");
    }
  }


  @DeleteMapping("/deletar/{id}")
  @Operation(summary = "Deletar cliente", description = "Rota deleta um cliente")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Cliente deletado"),
          @ApiResponse(responseCode = "400", description = "Erro ao deletar cliente")
  })
  public ResponseEntity<?> deletarClientePorId(@PathVariable Long id){
    ClienteDTO clienteDeletado = clienteService.listarClientePorId(id);
    if(clienteDeletado != null){
      return ResponseEntity.ok("Cliente de ID: "+id+" deletado com sucesso");
    }else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Cliente de ID "+id+ " não encontrado");
    }
  }
}
