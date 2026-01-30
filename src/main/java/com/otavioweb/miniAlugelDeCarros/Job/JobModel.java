package com.otavioweb.miniAlugelDeCarros.Job;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_jobs")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class JobModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String company;
  private String location;
  private String description;
  private String type;
  private String level;

  public void setId(Long id) {
    this.id = id;
  }
}
