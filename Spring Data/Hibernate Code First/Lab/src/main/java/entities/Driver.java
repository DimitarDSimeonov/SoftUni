package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @ManyToMany
    private Set<Truck> trucks;
}
