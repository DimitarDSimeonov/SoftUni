package entities;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {

    @Id
    @GeneratedValue (strategy = GenerationType.TABLE)
    private long id;

    @Basic
    private String type;

    @Basic
    private String model;

    @Basic
    private BigDecimal price;

    @Basic
    private String fuelType;

    protected Vehicle () {}
}
