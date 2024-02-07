package com.example.neo4jpersonregistration;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final DatabaseConnector databaseConnector;

    public PersonController() {
        // Assuming the URI, user, and password are predefined or configured elsewhere
        this.databaseConnector = new DatabaseConnector("bolt://localhost:7687", "neo4j", "password");
    }

    @PostMapping("/register")
    public String registerPerson(@RequestBody Person person) {
        try {
            databaseConnector.registerPerson(person);
            return "Person registered successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to register person";
        }
    }
}
