package entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table (name = "trucks")
public class Truck extends Vehicle{

    @Basic
    private Double loadCapacity;
    

    public Truck() {}

    public Truck (Double loadCapacity) {
        super();
        this.loadCapacity = loadCapacity;
    }
}
