package com.ahmadah.clustereddatawarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClusteredDataWarehouseApplication {
    @GetMapping("/")
    public String hello(){
        return "Hello";
    }
    public static void main(String[] args) {
        SpringApplication.run(ClusteredDataWarehouseApplication.class, args);
    }

}
