package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table (name = "students")
public class Student {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "phone_number", unique = true)
    private String phoneNumber;

    @Column (name = "average_grade")
    private Double averageGrade;

    @Column (name = "attendance")
    private Integer attendance;

    @ManyToMany (mappedBy = "students")
    private Set<Course> courses;
}
