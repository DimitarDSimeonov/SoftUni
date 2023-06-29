package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Teacher {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "phone_number", unique = true)
    private String phoneNumber;

    @Column (name = "email", unique = true)
    private String email;

    @Column (name = "salary_per_hour",
            nullable = false)
    private String salaryPerHour;

    @OneToMany (mappedBy = "teacher")
    private Set<Course> courses;
}
