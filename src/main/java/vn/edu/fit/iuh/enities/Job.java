package vn.edu.fit.iuh.enities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "job")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_id")
    private long id;
    @Column(name="job_desc",columnDefinition = "varchar(2000)")
    private String description;
    @Column(name="job_name",columnDefinition = "varchar(2000)")
    private String name;
    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;
    @OneToMany(mappedBy = "job")
    List<JobSkill> jobSkills;

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", company=" + company +
                '}';
    }
}
