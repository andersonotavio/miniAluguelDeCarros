package com.otavioweb.miniAlugelDeCarros.Carros;

import com.otavioweb.miniAlugelDeCarros.Cliente.ClienteModel;
import jakarta.persistence.*;



@Entity
@Table(name = "tb_carros")
public class CarroModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String marca;
  private String modelo;
  private int ano;

  //Um carro tem um unico cliente
  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private ClienteModel clientes;

  public CarroModel() {
  }

  public CarroModel(int ano, String modelo, String marca) {
    this.ano = ano;
    this.modelo = modelo;
    this.marca = marca;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public String getModelo() {
    return modelo;
  }

  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public String getMarca() {
    return marca;
  }

  public void setMarca(String marca) {
    this.marca = marca;
  }
}
