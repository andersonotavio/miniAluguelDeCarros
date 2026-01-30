package com.otavioweb.miniAlugelDeCarros.Job;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobService {
  private final JobRepository jobRepository;
  private final JobMapper jobMapper;

  public JobService(JobMapper jobMapper, JobRepository jobRepository) {
    this.jobMapper = jobMapper;
    this.jobRepository = jobRepository;
  }


  public List<JobDTO> listarJobs(){
    List<JobModel> jobs = jobRepository.findAll();
    return jobs.stream()
            .map(jobMapper::map)
            .collect(Collectors.toList());
  }

  public JobDTO listarJobPorId(Long id){
    Optional<JobModel> jobPorId = jobRepository.findById(id);
    return jobPorId.map(jobMapper::map).orElse(null);
  }

  public JobDTO adicionarJob(JobDTO jobDTO){
    JobModel job = jobMapper.map(jobDTO);
    job = jobRepository.save(job);
    return jobMapper.map(job);
  }

  public void deletarJob(Long id){
    jobRepository.deleteById(id);
  }

  public JobDTO atualizarJob(Long id, JobDTO jobDTO){
    Optional<JobModel> jobExistente = jobRepository.findById(id);
    if(jobExistente.isPresent()){
      JobModel jobAtualizado = jobMapper.map(jobDTO);
      jobAtualizado.setId(id);
      JobModel jobSalvo = jobRepository.save(jobAtualizado);
      return jobMapper.map(jobSalvo);
    }
    return null;
  }
  
  public List<JobDTO> buscarJobsPorLocalizacao(String location){
    List<JobModel> jobs = jobRepository.findByLocationContainingIgnoreCase(location);
    return jobs.stream()
            .map(jobMapper::map)
            .collect(Collectors.toList());
  }
  
  public List<JobDTO> buscarJobsPorTitulo(String title){
    List<JobModel> jobs = jobRepository.findByTitleContainingIgnoreCase(title);
    return jobs.stream()
            .map(jobMapper::map)
            .collect(Collectors.toList());
  }
}
