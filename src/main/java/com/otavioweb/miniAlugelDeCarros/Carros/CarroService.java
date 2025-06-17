package com.otavioweb.miniAlugelDeCarros.Carros;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
  private CarroRepository carroRepository;
  private CarroMapper carroMapper;

  public CarroService(CarroMapper carroMapper, CarroRepository carroRepository) {
    this.carroMapper = carroMapper;
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

  public CarroDTO adicionarCarro(CarroDTO carroDTO){
    CarroModel carro = carroMapper.map(carroDTO);
    carro = carroRepository.save(carro);
    return carroMapper.map(carro);
  }

  public void deletarCarro(Long id){
    carroRepository.deleteById(id);
  }
}
