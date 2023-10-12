package vn.edu.fit.iuh.enities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="experience")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Experience {
    @Id
    @Column(name = "exp_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "to_date",columnDefinition = "date")
    private LocalDate toDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "from_date",columnDefinition = "date")
    private LocalDate fromDate;
    @ManyToOne
    @JoinColumn(name="can_id")
    private Candidate candidate;
    @Column(name = "company",columnDefinition = "varchar(120)")
    private String companyName;
    @Column(name = "role",columnDefinition = "varchar(100)")
    private String role;
    @Column(name = "work_desc",columnDefinition = "varchar(400)")
    private String workDescription;
}
