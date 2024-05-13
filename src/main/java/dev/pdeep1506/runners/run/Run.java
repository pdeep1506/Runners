package dev.pdeep1506.runners.run;

import java.time.LocalDateTime;

public record Run(Integer id,
                  String title,
                  LocalDateTime startedOn,
                  LocalDateTime  completedO,
                  Integer miles,
                  Location location
                  ) { }


