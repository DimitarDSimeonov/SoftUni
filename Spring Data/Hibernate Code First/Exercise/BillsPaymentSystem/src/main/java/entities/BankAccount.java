package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
public class BankAccount extends BillingDetail{

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "SWIFT_code", nullable = false)
    private String SWIFT;
}
