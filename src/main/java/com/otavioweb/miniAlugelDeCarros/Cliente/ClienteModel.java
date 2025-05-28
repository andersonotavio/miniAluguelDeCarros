package com.otavioweb.miniAlugelDeCarros.Cliente;

import com.otavioweb.miniAlugelDeCarros.Carros.CarroModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_cliente")
public class ClienteModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;

  //Um cliente pode alugar mais de um carro
  @OneToMany(mappedBy = "clientes")
  private List<CarroModel> carro;

}
