package softuni.exam.models.dto;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name = "task")
@XmlAccessorType(XmlAccessType.FIELD)
public class TaskImportDto {

    @XmlElement
    private String date;

    @XmlElement
    @Positive
    private BigDecimal price;

    @XmlElement
    private CarToTaskDto car;

    @XmlElement
    private MechanicToTaskDto mechanic;

    @XmlElement
    private PartToTaskDto part;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CarToTaskDto getCar() {
        return car;
    }

    public void setCar(CarToTaskDto car) {
        this.car = car;
    }

    public MechanicToTaskDto getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicToTaskDto mechanic) {
        this.mechanic = mechanic;
    }

    public PartToTaskDto getPart() {
        return part;
    }

    public void setPart(PartToTaskDto part) {
        this.part = part;
    }
}
