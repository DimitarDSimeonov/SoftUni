package softuni.exam.models.dto;

import softuni.exam.models.entity.CarType;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CarImportDto {

    @XmlElement
    @NotNull
    @Size(min = 2, max = 30)
    private String carMake;

    @XmlElement
    @NotNull
    @Size(min = 2, max = 30)
    private String carModel;

    @XmlElement
    @Positive
    @NotNull
    private Integer year;

    @XmlElement
    @Size(min = 2, max = 30)
    @NotNull
    private String plateNumber;

    @XmlElement
    @NotNull
    @Positive
    private Integer kilometers;

    @XmlElement
    @NotNull
    @DecimalMin(value = "1.00")
    private Double engine;

    @XmlElement
    @NotNull
    private CarType carType;

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public Integer getKilometres() {
        return kilometers;
    }

    public void setKilometres(Integer kilometres) {
        this.kilometers = kilometres;
    }

    public Double getEngine() {
        return engine;
    }

    public void setEngine(Double engine) {
        this.engine = engine;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
}
