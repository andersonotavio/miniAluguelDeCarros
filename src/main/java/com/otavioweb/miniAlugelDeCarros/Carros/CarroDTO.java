package com.otavioweb.miniAlugelDeCarros.Carros;

import com.otavioweb.miniAlugelDeCarros.Cliente.ClienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarroDTO {

  private Long id;
  private String marca;
  private String modelo;
  private int ano;
  private String status;
  private ClienteModel clientes;
}
