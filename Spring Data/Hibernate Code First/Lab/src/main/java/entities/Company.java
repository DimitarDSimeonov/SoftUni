package entities;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table (name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String name;

}
