package com.otavioweb.miniAlugelDeCarros.Carros;

import com.otavioweb.miniAlugelDeCarros.Cliente.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "tb_carros")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "clientes")
public class CarroModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String marca;
  private String modelo;
  private int ano;
  private String imgUrl;
  //Um carro tem um unico cliente
  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private ClienteModel clientes;


  public void setId(Long id) {
    this.id = id;
  }
}
