package com.sidtech;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BioController {

    @GetMapping("/")
    public String showBio() {
        return """
               === My Bio ===<br>
               Name: Siddesh G P<br>
               Education: B.E in Computer Science<br>
               Skills: Java, DevOps, Docker, CI/CD
               """;
    }
}
