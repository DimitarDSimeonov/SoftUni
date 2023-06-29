package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name")
    private String name;

    @Column (name = "description",
            columnDefinition = "TEXT")
    private String definition;

    @Column (name = "start_date")
    private Date startDate;

    @Column (name = "end_date")
    private Date endDate;

    @Column (name = "credits")
    private Integer credits;

    @ManyToMany
    private Set<Student> students;

    @ManyToOne
    private Teacher teacher;
}
