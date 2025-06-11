package com.otavioweb.miniAlugelDeCarros.Carros;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
  private CarroRepository carroRepository;

  public CarroService(CarroRepository carroRepository) {
    this.carroRepository = carroRepository;
  }

  public List<CarroModel> listarCarros(){
    return carroRepository.findAll();
  }
  public CarroModel listarCarroPorId(Long id){
    Optional<CarroModel> carroPorId = carroRepository.findById(id);
    return carroPorId.orElse(null);
  }
}
