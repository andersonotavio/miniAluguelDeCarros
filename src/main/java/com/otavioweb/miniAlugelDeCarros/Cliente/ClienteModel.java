package com.otavioweb.miniAlugelDeCarros.Cliente;

import com.otavioweb.miniAlugelDeCarros.Carros.CarroModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
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
