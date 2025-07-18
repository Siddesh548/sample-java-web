package com.sidtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class BioApp {
    public static void main(String[] args) {
        // Create a new Spring application
        SpringApplication app = new SpringApplication(BioApp.class);

        // Set properties directly in code
        Map<String, Object> props = new HashMap<>();
        props.put("server.port", 8081); // ✅ Change port here

        app.setDefaultProperties(props);
        app.run(args);

        // Show the link in terminal
        System.out.println("👉 Web App running at: http://localhost:8081");
    }
}

