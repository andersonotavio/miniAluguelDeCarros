package com.otavioweb.miniAlugelDeCarros.Cliente;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
  private ClienteRepository clienteRepository;

  public ClienteService(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  public List<ClienteModel> listarClientes(){
    return clienteRepository.findAll();
  }

  public ClienteModel listarClientePorId(Long id){
    Optional<ClienteModel> clientePorId = clienteRepository.findById(id);
    return clientePorId.orElse(null);
  }

  public ClienteModel cadastrarCliente(ClienteModel cliente){
    return clienteRepository.save(cliente);
  }
  public void deletarCliente(Long id){
    clienteRepository.deleteById(id);
  }
}
