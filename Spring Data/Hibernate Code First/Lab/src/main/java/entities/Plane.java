package entities;

import javax.persistence.*;

@Entity
@Table (name = "planes")
public class Plane extends Vehicle{

    @Basic
    private Integer passengerCapacity;

    @ManyToOne
    @JoinColumn (name = "company_id",
    referencedColumnName = "id")
    private Company company;

    public Plane() {}

    public Plane (Integer passengerCapacity) {
        super();
        this.passengerCapacity = passengerCapacity;
    }
}
