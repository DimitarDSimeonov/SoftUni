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
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private  String  name;

    @OneToMany(mappedBy = "competition")
    private Set<Game> games;

    @OneToOne
    private CompetitionType competitionType;
}
