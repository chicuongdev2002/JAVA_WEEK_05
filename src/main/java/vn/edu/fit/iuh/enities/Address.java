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
    @OneToOne
   private Candidate candidate;
    @OneToOne
   private Company company;
//    public Adress(UUID id) {
//        this.id = id;
//    }
}
