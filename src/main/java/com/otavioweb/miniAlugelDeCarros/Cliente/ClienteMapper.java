package com.otavioweb.miniAlugelDeCarros.Cliente;

import com.otavioweb.miniAlugelDeCarros.Carros.CarroModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {
  public ClienteModel map(ClienteDTO clienteDTO){
    ClienteModel clienteModel = new ClienteModel();

    clienteModel.setId(clienteDTO.getId());
    clienteModel.setNome(clienteDTO.getNome());
    clienteModel.setEmail(clienteDTO.getEmail());

    return clienteModel;
  }

  public ClienteDTO map(ClienteModel clienteModel){

    ClienteDTO clienteDTO = new ClienteDTO();

    clienteDTO.setId(clienteModel.getId());
    clienteDTO.setNome(clienteModel.getNome());
    clienteDTO.setEmail(clienteModel.getEmail());

    return clienteDTO;
  }

  public List<ClienteDTO> dtoList(List<ClienteModel> listCarros){
    return listCarros.stream()
            .map(this::map)
            .collect(Collectors.toList());
  }
}
