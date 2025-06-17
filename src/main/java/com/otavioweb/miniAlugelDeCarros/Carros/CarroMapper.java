package com.otavioweb.miniAlugelDeCarros.Carros;

import org.springframework.stereotype.Component;

@Component
public class CarroMapper {
  public CarroModel map(CarroDTO carroDTO){
    CarroModel carroModel = new CarroModel();

    carroModel.setId(carroDTO.getId());
    carroModel.setMarca(carroDTO.getMarca());
    carroModel.setModelo(carroDTO.getModelo());
    carroModel.setAno(carroDTO.getAno());
    carroModel.setStatus(carroDTO.getStatus());
    carroModel.setClientes(carroDTO.getClientes());

    return carroModel;
  }

  public CarroDTO map(CarroModel carroModel) {
    CarroDTO carroDTO = new CarroDTO();

    carroDTO.setId(carroModel.getId());
    carroDTO.setMarca(carroModel.getMarca());
    carroDTO.setModelo(carroModel.getModelo());
    carroDTO.setAno(carroModel.getAno());
    carroDTO.setStatus(carroModel.getStatus());
    carroDTO.setClientes(carroModel.getClientes());

    return carroDTO;
  }
}
