package vn.edu.fit.iuh.enities;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.fit.iuh.enums.SkillType;

import java.util.List;
import java.util.UUID;
@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="skill_id")
    private long id;
@Column(name="skill_description",columnDefinition = "varchar(300)")
    private String skillDescription;
    @Column(name="skill_name",columnDefinition = "varchar(150)")
    private String skillName;
@Column(name="skill_type",columnDefinition = "tinyint(4)")
@Enumerated(EnumType.ORDINAL)
    private SkillType type;
@OneToMany
@JoinColumn
private List<JobSkill> jobSkills;


//    public Skill(UUID skill_id) {
//        this.skill_id = skill_id;
//    }

}
