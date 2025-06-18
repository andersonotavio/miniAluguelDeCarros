package com.otavioweb.miniAlugelDeCarros.Cliente;

import com.otavioweb.miniAlugelDeCarros.Carros.CarroModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

  private Long id;
  private String nome;
  private String email;
}
