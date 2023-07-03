package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private  String  name;

    @OneToOne
    private Team homeTeam;

    @OneToOne
    private Team awayTeam;

    @Column(name = "home_goals")
    private Integer homeGoals;

    @Column(name = "away_goals")
    private Integer awayGoals;

    @Column(name = "date_time")
    private Date dateAndTime;

    @Column(name = "home_team_win_bet_rate")
    private Double homeTeamWinBetRate;

    @Column(name = "away_team_win_bet_rate")
    private Double awayTeamWinBetRate;

    @Column(name = "draw_game_bet_rate")
    private Double drawGameBetRate;

    @OneToOne
    private Round round;

    @OneToOne
    private Competition competition;
}
