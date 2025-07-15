package ru.bolnik.mongodb.service;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void printAllPlanets() {
        List<Document> planets = mongoTemplate.findAll(Document.class, "planets");

        for (Document planet : planets) {
            System.out.println(planet.toJson());
        }
    }
}
