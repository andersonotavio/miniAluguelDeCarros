package com.otavioweb.miniAlugelDeCarros.Cliente;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.otavioweb.miniAlugelDeCarros.Carros.CarroModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_cliente")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ClienteModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(unique = true)
  private String email;

  //Um cliente pode alugar mais de um carro
  @OneToMany(mappedBy = "clientes")
  @JsonIgnore
  private List<CarroModel> carro;

}
