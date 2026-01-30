package com.otavioweb.miniAlugelDeCarros.Job;

import org.springframework.stereotype.Component;

@Component
public class JobMapper {
  public JobModel map(JobDTO jobDTO){
    JobModel jobModel = new JobModel();

    jobModel.setId(jobDTO.getId());
    jobModel.setTitle(jobDTO.getTitle());
    jobModel.setCompany(jobDTO.getCompany());
    jobModel.setLocation(jobDTO.getLocation());
    jobModel.setDescription(jobDTO.getDescription());
    jobModel.setType(jobDTO.getType());
    jobModel.setLevel(jobDTO.getLevel());

    return jobModel;
  }

  public JobDTO map(JobModel jobModel) {
    JobDTO jobDTO = new JobDTO();

    jobDTO.setId(jobModel.getId());
    jobDTO.setTitle(jobModel.getTitle());
    jobDTO.setCompany(jobModel.getCompany());
    jobDTO.setLocation(jobModel.getLocation());
    jobDTO.setDescription(jobModel.getDescription());
    jobDTO.setType(jobModel.getType());
    jobDTO.setLevel(jobModel.getLevel());

    return jobDTO;
  }
}
