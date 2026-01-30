package com.otavioweb.miniAlugelDeCarros.Job;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("job")
public class JobController {
  private final JobService jobService;

  public JobController(JobService jobService) {
    this.jobService = jobService;
  }

  @GetMapping("/")
  @Operation(summary = "Mensagem de boas vindas", description = "Essa rota da uma mensagem de boas vindas para quem acessa ela")
  public String welcome(){
    return "Welcome to Job Search API";
  }


  @PostMapping("/adicionar")
  @Operation(summary = "Adiciona uma nova vaga", description = "Rota adiciona uma nova vaga e insere no banco de dados")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "201", description = "Vaga adicionada com sucesso"),
          @ApiResponse(responseCode = "400", description = "Erro na adição da nova vaga")
  })
  public ResponseEntity<String> adicionarJob(@RequestBody JobDTO job){

    JobDTO novaVaga = jobService.adicionarJob(job);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Vaga adicionada com sucesso: " + novaVaga.getTitle() + " (ID): " + novaVaga.getId());
  }


  @GetMapping("/listar")
  @Operation(summary = "Lista todas as vagas", description = "Rota lista todas as vagas no banco de dados")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Vagas listadas"),
          @ApiResponse(responseCode = "404", description = "Rota não encontrada")
  })
  public ResponseEntity<List<JobDTO>> listarJobs(){
    List<JobDTO> jobs = jobService.listarJobs();
    return ResponseEntity.ok(jobs);
  }

  @GetMapping("/listar/{id}")
  @Operation(summary = "Lista a vaga por ID", description = "Rota lista uma vaga por ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Vaga listada"),
          @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
  })
  public ResponseEntity<?> mostrarJobPorId(@PathVariable Long id){

    if(jobService.listarJobPorId(id) != null){
     JobDTO job = jobService.listarJobPorId(id);
      return ResponseEntity.ok(job);
    }else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Vaga com ID: " + id + " não encontrada");
    }
  }


  @PutMapping("/alterar/{id}")
  @Operation(summary = "Alterar os dados da vaga", description = "Rota altera os dados da vaga por ID")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Vaga alterada"),
          @ApiResponse(responseCode = "404", description = "Vaga não encontrada")
  })
  public ResponseEntity<?> alterarJobPorId(@PathVariable Long id, @RequestBody JobDTO job){
    if(jobService.listarJobPorId(id) != null ){
      JobDTO jobAtualizado = jobService.atualizarJob(id, job);
      return ResponseEntity.ok(jobAtualizado);
    }else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Vaga de ID: " +id+ " não encontrada");
    }

  }

  @DeleteMapping("/deletar/{id}")
  @Operation(summary = "Deletar vaga", description = "Rota deleta uma vaga")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Vaga deletada"),
          @ApiResponse(responseCode = "400", description = "Erro ao deletar vaga")
  })
  public ResponseEntity<String> deletarJobPorId(@PathVariable Long id){
      if(jobService.listarJobPorId(id) != null){
        jobService.deletarJob(id);
        return ResponseEntity.ok("Vaga de ID: " +id+ " deletada com sucesso");
      }else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("A vaga de id " +id+ " não foi encontrada");
      }
  }
  
  @GetMapping("/buscar/localizacao/{location}")
  @Operation(summary = "Buscar vagas por localização", description = "Rota busca vagas filtradas por localização")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Vagas encontradas"),
          @ApiResponse(responseCode = "404", description = "Nenhuma vaga encontrada")
  })
  public ResponseEntity<List<JobDTO>> buscarJobsPorLocalizacao(@PathVariable String location){
    List<JobDTO> jobs = jobService.buscarJobsPorLocalizacao(location);
    return ResponseEntity.ok(jobs);
  }
  
  @GetMapping("/buscar/titulo/{title}")
  @Operation(summary = "Buscar vagas por título", description = "Rota busca vagas filtradas por título")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Vagas encontradas"),
          @ApiResponse(responseCode = "404", description = "Nenhuma vaga encontrada")
  })
  public ResponseEntity<List<JobDTO>> buscarJobsPorTitulo(@PathVariable String title){
    List<JobDTO> jobs = jobService.buscarJobsPorTitulo(title);
    return ResponseEntity.ok(jobs);
  }
}
