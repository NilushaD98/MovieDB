package com.example.moviedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.moviedb.services.ServiceIMPL.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class MovieDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieDbApplication.class, args);
    }

}
