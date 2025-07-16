package ru.bolnik.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.bolnik.mongodb.entity.Comet;

import java.util.Optional;

public interface CometRepository extends MongoRepository<Comet, String> {
    Optional<Comet> findByName(String name);

    void deleteByName(String name);
}
