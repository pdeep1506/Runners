package dev.pdeep1506.runners.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> FindById(Integer Id){
        return  runs.stream()
                .filter(runs -> runs.id() == Id)
                .findFirst();

    }

    void create(Run run){
        runs.add(run);
    }

    void update(Run run, Integer id){
            Optional<Run> existingRun = FindById(id);

            if(existingRun.isPresent()){
                runs.set(runs.indexOf(existingRun.get()),run);
            }
    }

    void delete(Integer id){
        runs.removeIf(run -> run.id().equals(id));
    }

    @PostConstruct
    private  void  init(){
        runs.add(new Run(1,
                "Monday Morinin run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(20, ChronoUnit.MINUTES),
                3,
                Location.INDOOR
                ));

        runs.add(new Run(2,
                "Monday Evening run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(40, ChronoUnit.MINUTES),
                5,
                Location.OUTDOOR
        ));
    }

}
