package vn.edu.fit.iuh.enities;

import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Table(name = "company")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comp_id;
    @Column(name = "about",columnDefinition = "varchar(2000)")
    private String about;
    @Column(name = "email",columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "comp_name",columnDefinition = "varchar(2000)")
    private String name;
    @Column(name = "phone",columnDefinition = "varchar(2000)")
    private String phone;
    @Column(name = "webURL",columnDefinition = "varchar(2000)")
    private String web_url;
    @OneToOne
    @JoinColumn(name = "address")
    private Address address;
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;


}
