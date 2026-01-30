package com.otavioweb.miniAlugelDeCarros.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepository extends JpaRepository<JobModel, Long> {
  
  @Query("SELECT j FROM JobModel j WHERE LOWER(j.location) LIKE LOWER(CONCAT('%', :location, '%'))")
  List<JobModel> findByLocationContainingIgnoreCase(@Param("location") String location);
  
  @Query("SELECT j FROM JobModel j WHERE LOWER(j.title) LIKE LOWER(CONCAT('%', :title, '%'))")
  List<JobModel> findByTitleContainingIgnoreCase(@Param("title") String title);
}
