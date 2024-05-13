package dev.pdeep1506.runners.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
public record Run(

        Integer id,


                  @NotEmpty
                  String title,
                  LocalDateTime startedOn,
                  LocalDateTime  completedO,
                  @Positive
                  Integer miles,
                  Location location
                  ) {

    public  Run{
         if(!completedO.isAfter(startedOn)){
             throw new IllegalArgumentException("Completed On must be after started on.");
         }

    }
}


