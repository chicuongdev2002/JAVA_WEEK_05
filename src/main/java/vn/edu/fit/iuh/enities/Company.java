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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "add_id",name = "address")
    private Address address;
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", about='" + about + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", web_url='" + web_url + '\'' +
                ", address=" + address.getId() +
                '}';
    }
}
