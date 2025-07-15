package ru.bolnik.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.bolnik.mongodb.entity.Planet;

import java.util.List;

public interface PlanetRepository extends MongoRepository<Planet, String> {

    List<Planet> findByHasRings(boolean hasRings);

    List<Planet> findByHasRingsAndMainAtmosphere(boolean hasRings, String mainAtmosphere);

    @Query("{ 'orderFromSun' : { $gt: ?0 } }")
    List<Planet> findByOrderFromSunGreaterThan(int order);
}
