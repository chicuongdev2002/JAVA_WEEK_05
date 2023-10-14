package vn.edu.fit.iuh.enities;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.fit.iuh.enums.SkillLevel;

@Entity
@Table(name="job_skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(JobSkillIID.class)
public class JobSkill {
    @Column(name = "more_infos")
    private String moreInfo;
    @Column(name="skill_level",columnDefinition = "tinyint(4)")
    private SkillLevel skillLevel;
    @Id
    @ManyToOne
    @JoinColumn(name="job_id")
    private Job job;
    @Id
    @ManyToOne
    @JoinColumn(name="skill_id")
    private Skill skill;
}
