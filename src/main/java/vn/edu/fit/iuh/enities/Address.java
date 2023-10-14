package vn.edu.fit.iuh.enities;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "add_id")
    private long id;
    @Column(name = "street",columnDefinition = "varchar(150)")
    private String street;
    @Column(name = "city",columnDefinition = "varchar(50)")
    private String city;
    private int country;
    @Column(name = "number",columnDefinition = "varchar(20)")
    private String number;
    @Column(name = "phone",columnDefinition = "varchar(7)")
    private String zipcode;
    @OneToOne(mappedBy = "address")
   private Candidate candidate;
    @OneToOne(mappedBy = "address")
   private Company company;

    @Override
    public String toString() {
        return "company{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", country=" + country +
                ", number='" + number + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
