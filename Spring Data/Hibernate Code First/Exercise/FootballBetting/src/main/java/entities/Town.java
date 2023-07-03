package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private  String  name;

    @OneToOne
    private Country country;

    @OneToMany(mappedBy = "town")
    private Set<Team> teams;
}
