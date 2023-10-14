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
    @Column(name = "comp_id")
    private long id;
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
    @JoinColumn(referencedColumnName = "add_id",name = "company")
    private company company;
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;


}
