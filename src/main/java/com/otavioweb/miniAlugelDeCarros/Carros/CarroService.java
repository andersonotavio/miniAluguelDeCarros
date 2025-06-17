package com.otavioweb.miniAlugelDeCarros.Carros;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {
  private CarroRepository carroRepository;
  private CarroMapper carroMapper;

  public CarroService(CarroMapper carroMapper, CarroRepository carroRepository) {
    this.carroMapper = carroMapper;
    this.carroRepository = carroRepository;
  }

  // Listar carros
  public List<CarroDTO> listarCarros(){
    List<CarroModel> carros = carroRepository.findAll();
    return carros.stream()
            .map(carroMapper::map)
            .collect(Collectors.toList());
  }
  //Listar carro por ID
  public CarroDTO listarCarroPorId(Long id){
    Optional<CarroModel> carroPorId = carroRepository.findById(id);
    return carroPorId.map(carroMapper::map).orElse(null);
  }

  public CarroDTO adicionarCarro(CarroDTO carroDTO){
    CarroModel carro = carroMapper.map(carroDTO);
    carro = carroRepository.save(carro);
    return carroMapper.map(carro);
  }

  public void deletarCarro(Long id){
    carroRepository.deleteById(id);
  }

  public CarroDTO atualizarCarro(Long id, CarroDTO carroDTO){
    Optional<CarroModel> carroExistente = carroRepository.findById(id);
    if(carroExistente.isPresent()){
      CarroModel carroAtualizado = carroMapper.map(carroDTO);
      carroAtualizado.setId(id);
      CarroModel carroSalvo = carroRepository.save(carroAtualizado);
      return carroMapper.map(carroSalvo);
    }
    return null;
  }
}
