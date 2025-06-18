package com.otavioweb.miniAlugelDeCarros.Cliente;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
  private ClienteRepository clienteRepository;
  private ClienteMapper clienteMapper;

  public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
    this.clienteRepository = clienteRepository;
    this.clienteMapper = clienteMapper;
  }

  public List<ClienteModel> listarClientes(){
    return clienteRepository.findAll();
  }

  public ClienteModel listarClientePorId(Long id){
    Optional<ClienteModel> clientePorId = clienteRepository.findById(id);
    return clientePorId.orElse(null);
  }

  public ClienteDTO cadastrarCliente(ClienteDTO clienteDTO){
    ClienteModel cliente = clienteMapper.map(clienteDTO);
    cliente = clienteRepository.save(cliente);
    return clienteMapper.map(cliente);
  }

  public void deletarCliente(Long id){
    clienteRepository.deleteById(id);
  }
}
