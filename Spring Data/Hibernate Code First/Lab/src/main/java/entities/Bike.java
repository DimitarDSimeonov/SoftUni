package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "bikes")
public class Bike extends Vehicle {

    public Bike() {}
}
