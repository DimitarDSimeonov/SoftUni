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
public class Position {

    @Id
    @Column(length = 2)
    private String id;

    @Column
    private String description;

    @OneToMany(mappedBy = "position")
    private Set<Player> players;
}
