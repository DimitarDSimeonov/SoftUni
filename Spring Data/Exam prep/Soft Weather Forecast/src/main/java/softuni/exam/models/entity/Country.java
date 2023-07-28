package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity{

    @Column(name = "country_name", nullable = false, unique = true)
    private String countryName;

    @Column(nullable = false)
    private String currency;

    public Country() {
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countyName) {
        this.countryName = countyName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
