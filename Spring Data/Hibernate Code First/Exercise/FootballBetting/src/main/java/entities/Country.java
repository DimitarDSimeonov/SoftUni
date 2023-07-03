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
public class Country {

    @Id
    @Column(length = 3)
    private String id;

    @Column
    private String name;

    @OneToMany(mappedBy = "country")
    private Set<Town> towns;

    @ManyToMany
    private Set<Continent> continents;
}
