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

  // Listar carros
  public List<CarroModel> listarCarros(){
    return carroRepository.findAll();
  }
  //Listar carro por ID
  public CarroModel listarCarroPorId(Long id){
    Optional<CarroModel> carroPorId = carroRepository.findById(id);
    return carroPorId.orElse(null);
  }

  public CarroModel adicionarCarro(CarroModel carro){
    return carroRepository.save(carro);
  }

  public void deletarCarro(Long id){
    carroRepository.deleteById(id);
  }
}
