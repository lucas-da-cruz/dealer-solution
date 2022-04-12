package com.exercise.dealersolution;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
@Slf4j
public class DealerSolutionApplication {

  public static void main(String[] args) {
    log.info("Dealer-solution - {} - Iniciando aplicação Dealer Solution", LocalDateTime.now());
    SpringApplication.run(DealerSolutionApplication.class, args);
    log.info("Dealer-solution - {} - Aplicação Dealer Solution inicializada", LocalDateTime.now());
  }

}
