package ru.bolnik.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comets")
public class Comet {
    @Id
    private String id;
    private String name;
    private double perihelion; // Перигелий (ближайшая точка к Солнцу в а.е.)
    private double aphelion;   // Афелий (дальняя точка от Солнца в а.е.)
    private boolean periodic;  // Периодическая или нет

    // Геттеры и сеттеры
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPerihelion() { return perihelion; }
    public void setPerihelion(double perihelion) { this.perihelion = perihelion; }

    public double getAphelion() { return aphelion; }
    public void setAphelion(double aphelion) { this.aphelion = aphelion; }

    public boolean isPeriodic() { return periodic; }
    public void setPeriodic(boolean periodic) { this.periodic = periodic; }

    @Override
    public String toString() {
        return "Comet{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", perihelion=" + perihelion +
               ", aphelion=" + aphelion +
               ", periodic=" + periodic +
               '}';
    }
}
