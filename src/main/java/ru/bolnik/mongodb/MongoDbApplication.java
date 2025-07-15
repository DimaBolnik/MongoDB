package ru.bolnik.mongodb;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bolnik.mongodb.entity.Comet;
import ru.bolnik.mongodb.entity.Planet;
import ru.bolnik.mongodb.repository.CometRepository;
import ru.bolnik.mongodb.repository.PlanetRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MongoDbApplication implements CommandLineRunner {


    private PlanetRepository planetRepository;

    private CometRepository cometRepository;

    public MongoDbApplication(PlanetRepository planetRepository, CometRepository cometRepository) {
        this.planetRepository = planetRepository;
        this.cometRepository = cometRepository;
    }

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("MONGODB_URI", dotenv.get("MONGODB_URI"));
        SpringApplication.run(MongoDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        // Найти комету по текущему имени
//        String oldName = "Halley";
//        String newName = "New Halley";
//
//        // Ищем комету
//        Optional<Comet> cometOpt = cometRepository.findByName(oldName);
//
//        if (cometOpt.isPresent()) {
//            Comet comet = cometOpt.get();
//            // Меняем название
//            comet.setName(newName);
//            // Сохраняем обратно
//            cometRepository.save(comet);
//            System.out.println("Комета обновлена: " + comet);
//        } else {
//            System.out.println("Комета с именем " + oldName + " не найдена");
//        }


        List<Comet> comets = cometRepository.findAll();

        comets.forEach(pl -> System.out.println(pl.getName()));


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

//        List<Planet> planets = planetRepository.findByOrderFromSunGreaterThan(2);
//        planets.sort(Comparator.comparing(Planet::getOrderFromSun));
//        for (var planet : planets) {
//            System.out.println("Name: " + planet.getName());
//            System.out.println("Order from Sun: " + planet.getOrderFromSun());
//            System.out.println("Has rings: " + planet.isHasRings());
//            System.out.println("Main atmosphere: " + planet.getMainAtmosphere());
//            var temperature = planet.getSurfaceTemperatureC();
//            if (temperature != null) {
//                System.out.println("Surface temperature (min): " + temperature.getMin());
//                System.out.println("Surface temperature (max): " + temperature.getMax());
//                System.out.println("Surface temperature (avg): " + temperature.getAvg());
//            }
//            System.out.println("-----------------------------");
//        }
//    }
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

        //создание новой коллекции и добавления туда документов
        // Создаем новые кометы
//        Comet halley = new Comet();
//        halley.setName("Halley");
//        halley.setPerihelion(0.586); // В а.е.
//        halley.setAphelion(35.1);
//        halley.setPeriodic(true);
//
//        Comet haleBopp = new Comet();
//        haleBopp.setName("Hale-Bopp");
//        haleBopp.setPerihelion(0.914);
//        haleBopp.setAphelion(370);
//        haleBopp.setPeriodic(true);
//
//        // Сохраняем в коллекцию
//        cometRepository.save(halley);
//        cometRepository.save(haleBopp);
//
//        System.out.println("Кометы успешно добавлены!");


    }
}
