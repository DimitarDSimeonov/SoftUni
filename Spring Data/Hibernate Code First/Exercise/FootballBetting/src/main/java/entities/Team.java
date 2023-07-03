package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private  String  name;

    @Column
    private String logo;

    @Column(unique = true, length = 3)
    private String initials;

    @OneToOne
    private Color primaryKitColor;

    @OneToOne
    private Color secondaryKitColor;

    @OneToOne
    private Town town;

    @Column
    private BigDecimal budget;

    @OneToMany(mappedBy = "team")
    private Set<Player> players;
}
