package com.otavioweb.miniAlugelDeCarros.Job;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<JobModel, Long> {
  
  List<JobModel> findByLocationContainingIgnoreCase(String location);
  
  List<JobModel> findByTitleContainingIgnoreCase(String title);
}
