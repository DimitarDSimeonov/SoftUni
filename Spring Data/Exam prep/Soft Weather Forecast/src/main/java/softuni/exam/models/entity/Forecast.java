package softuni.exam.models.entity;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity{

    @Enumerated(value = EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek dayOfWeek;

    @Column(name = "max_temperature", nullable = false)
    private Double maxTemperature;

    @Column(name = "min_temperature", nullable = false)
    private Double minTemperature;

    @Column(nullable = false, columnDefinition = "TIME")
    private String sunrise;

    @Column(nullable = false, columnDefinition = "TIME")
    private String sunset;

    @ManyToOne
    private City city;

    public Forecast() {
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
