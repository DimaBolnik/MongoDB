package ru.bolnik.mongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "planets")
public class Planet {

    @Id
    private String id;

    private String name;
    private Integer orderFromSun;
    private boolean hasRings;
    private List<String> mainAtmosphere;
    private SurfaceTemperature surfaceTemperatureC;

    public static class SurfaceTemperature {
        private Integer min;
        private Integer max;
        private Integer avg;

        public Integer getMin() { return min; }
        public void setMin(Integer min) { this.min = min; }
        public Integer getMax() { return max; }
        public void setMax(Integer max) { this.max = max; }
        public Integer getAvg() { return avg; }
        public void setAvg(Integer avg) { this.avg = avg; }
    }

    // Геттеры и сеттеры
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getOrderFromSun() { return orderFromSun; }
    public void setOrderFromSun(Integer orderFromSun) { this.orderFromSun = orderFromSun; }

    public boolean isHasRings() { return hasRings; }
    public void setHasRings(boolean hasRings) { this.hasRings = hasRings; }

    public List<String> getMainAtmosphere() { return mainAtmosphere; }
    public void setMainAtmosphere(List<String> mainAtmosphere) { this.mainAtmosphere = mainAtmosphere; }

    public SurfaceTemperature getSurfaceTemperatureC() { return surfaceTemperatureC; }
    public void setSurfaceTemperatureC(SurfaceTemperature surfaceTemperatureC) { this.surfaceTemperatureC = surfaceTemperatureC; }
}
