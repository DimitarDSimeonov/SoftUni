package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private  String  name;

    @Column(name = "squad_number")
    private Integer squadNumber;

    @OneToOne
    private Team team;

    @OneToOne
    private Position position;

    @Column(name = "current_injured")
    private Boolean currentInjured;
}
