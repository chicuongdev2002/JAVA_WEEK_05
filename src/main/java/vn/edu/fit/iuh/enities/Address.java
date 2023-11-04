package vn.edu.fit.iuh.enities;

import com.neovisionaries.i18n.CountryCode;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "add_id")
    private long id;
    @Column(name = "street", columnDefinition = "varchar(150)")
    private String street;
    @Column(name = "city", columnDefinition = "varchar(50)")
    private String city;
    private CountryCode country;
    @Column(name = "number", columnDefinition = "varchar(20)")
    private String number;
    @Column(name = "phone", columnDefinition = "varchar(7)")
    private String zipcode;
    @OneToOne(mappedBy = "address")
    private Candidate candidate;
    @OneToOne(mappedBy = "address")
    private Company company;

    public Address(String street, String city, CountryCode country, String number, String zipcode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.number = number;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return
                "Street='" + street + '\'' +
                ", City='" + city + '\'' +
                ", Country=" + country +
                ", Number='" + number + '\'' +
                ", Zipcode='" + zipcode + '\''
                ;
    }
}
