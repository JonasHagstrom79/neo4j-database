package com.example.neo4jpersonregistration;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.neo4j.driver.Result;
import static org.neo4j.driver.Values.parameters;

public class DatabaseConnector {
    private final Driver driver;

    public DatabaseConnector(String uri, String user, String password) {
        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
    }

    public void close() throws Exception {
        driver.close();
    }

    public void registerPerson(Person person) {
        try (Session session = driver.session()) {
            String query = "CREATE (p:Person {name: $name, surname: $surname, address: $address, yearOfBirth: $yearOfBirth})";
            session.writeTransaction(tx -> {
                Result result = tx.run(query,
                        parameters("name", person.getName(), "surname", person.getSurname(), "address", person.getAddress(), "yearOfBirth", person.getYearOfBirth()));
                return result.single().get(0).asString();
            });
        }
    }
}
