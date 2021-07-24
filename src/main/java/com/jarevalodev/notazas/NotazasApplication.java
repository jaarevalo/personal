package com.jarevalodev.notazas;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class NotazasApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotazasApplication.class, args);
        log.info("| ----- Greetings from {} ----- |", "Earth 616");
    }

}
