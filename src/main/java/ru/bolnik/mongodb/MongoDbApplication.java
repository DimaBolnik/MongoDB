package ru.bolnik.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner {

    @Autowired
    private PlanetRepository planetRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        // Создаём новую планету
//        Planet fakePlanet = new Planet();
//        fakePlanet.setName("Fantazia");
//        fakePlanet.setOrderFromSun(15);
//        fakePlanet.setHasRings(true);
//        fakePlanet.setMainAtmosphere(List.of("Helium-X"));
//
//        // Задаём температуру
//        Planet.SurfaceTemperature temp = new Planet.SurfaceTemperature();
//        temp.setMin(-150);
//        temp.setMax(50);
//        temp.setAvg(-50);
//        fakePlanet.setSurfaceTemperatureC(temp);
//
//        // Сохраняем
//        planetRepository.save(fakePlanet);
//        System.out.println("Added fake planet: " + fakePlanet.getName());
        List<Planet> planets = planetRepository.findByOrderFromSunGreaterThan(2);
        planets.sort(Comparator.comparing(Planet::getOrderFromSun));
        for (var planet : planets) {
            System.out.println("Name: " + planet.getName());
            System.out.println("Order from Sun: " + planet.getOrderFromSun());
            System.out.println("Has rings: " + planet.isHasRings());
            System.out.println("Main atmosphere: " + planet.getMainAtmosphere());
            var temperature = planet.getSurfaceTemperatureC();
            if (temperature != null) {
                System.out.println("Surface temperature (min): " + temperature.getMin());
                System.out.println("Surface temperature (max): " + temperature.getMax());
                System.out.println("Surface temperature (avg): " + temperature.getAvg());
            }
            System.out.println("-----------------------------");
        }
    }
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Имя коллекции в БД
//        String collectionName = "planets";
//
//        MongoCollection<Document> collection = mongoTemplate.getCollection(collectionName);
//
//        Bson filter = Filters.eq("hasRings", true);
//        try (MongoCursor<Document> cursor = collection.find(filter).iterator()) {
//            while (cursor.hasNext()) {
//                Document doc = cursor.next();
//                // Получаем значение поля "name"
//                String name = doc.getString("name");
//                System.out.println("Planet name: " + name);
//            }
//        }

//    }
}
