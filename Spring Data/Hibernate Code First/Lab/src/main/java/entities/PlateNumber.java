package entities;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table (name = "plate_number")

public class PlateNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic
    private String number;
}
