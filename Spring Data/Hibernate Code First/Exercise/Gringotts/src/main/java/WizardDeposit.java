import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
@Table (name = "wizard_deposit")
public class WizardDeposit {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "first_name", length = 50)
    private String firstName;

    @Column (name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column (length = 1000, columnDefinition = "TEXT")
    private String note;

    @Column(nullable = false)
    private Integer age;

    @Column (name = "magic_wand_creator", length = 100)
    private String magicWandCreator;

    @Column (name = "magic_wand_size")
    private Integer magicWandSize;

    @Column(name = "deposit_group", length = 20)
    private String depositGroup;

    @Column(name = "deposit_start_date")
    private Date depositStartDate;

    @Column(name = "deposit_amount")
    private Double depositAmount;

    @Column(name = "deposit_interest")
    private Double depositInterests;

    @Column(name = "deposit_charge")
    private Double depositCharge;

    @Column(name = "deposit_expiration_date")
    private Date depositExpirationDate;

    @Column(name = "is_deposit_expired")
    private Boolean isDepositExpired;
}
