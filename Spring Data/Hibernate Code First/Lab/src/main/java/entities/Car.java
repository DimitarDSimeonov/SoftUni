package entities;

import javax.persistence.*;

@Entity
@Table (name = "cars")

public class Car extends Vehicle{

    @Basic
    private Integer seats;

    @OneToOne
    @JoinColumn (name = "plate_id" ,
            referencedColumnName = "id")
    private PlateNumber plateNumber;

    public Car() {}

    public Car (Integer seats) {
        super();
        this.seats = seats;
    }
}
