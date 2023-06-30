package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "names")
    private String name;

    @Column(name = "emails")
    private String email;

    @Column(name = "credit_card_number")
    private  String creditCardNumber;

    @Column(name = "sales")
    @OneToMany(mappedBy = "customer")
    private Set<Sale> sales;
}
