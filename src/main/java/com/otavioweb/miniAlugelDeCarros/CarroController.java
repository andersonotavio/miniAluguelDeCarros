package com.otavioweb.miniAlugelDeCarros;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroController {
  @GetMapping("/")
  public String welcome(){
    return "Welcome my app";
  }
}
