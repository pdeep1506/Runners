package dev.pdeep1506.runners.run;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/runs")
public class RunController {


  private final RunRepository runRepository;


  public RunController(RunRepository runRepository){
      this.runRepository = runRepository;
  }

  @GetMapping("")
   List<Run> findAll(){
       return runRepository.findAll();
   }


   @GetMapping("/{id}")
   Run findById(@PathVariable Integer id) {
      Optional<Run> run = runRepository.FindById(id);
      if(run.isEmpty()){
          throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
      else{
          return run.get();
      }
  }

  // Post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    void create(@RequestBody  Run run){
      runRepository.create(run);
    }


    // Update
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/update/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id){
            runRepository.update(run, id);
    }



    // Delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable Integer id){
        runRepository.delete(id);
    }

}
