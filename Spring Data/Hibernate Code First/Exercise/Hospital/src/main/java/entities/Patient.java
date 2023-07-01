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
public class Patient {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "addresses")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "picture",
            columnDefinition = "BLOB")
    private String picture;

    @Column(name = "has_medical_insurance")
    private Boolean hasMedicalInsurance;

    @OneToMany(mappedBy = "patient")
    private Set<Visitation> visitations;

    @OneToMany(mappedBy = "patient")
    private Set<Diagnose> diagnoses;

    @OneToMany(mappedBy = "patient")
    private Set<Medicament> medicaments;
}
