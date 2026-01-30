package com.otavioweb.miniAlugelDeCarros.Job;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDTO {

  private Long id;
  private String title;
  private String company;
  private String location;
  private String description;
  private String type;
  private String level;
}
