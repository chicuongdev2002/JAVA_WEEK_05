package vn.edu.fit.iuh.enities;

import jakarta.persistence.*;
import lombok.*;
import vn.edu.fit.iuh.enums.SkillLevel;

import java.util.UUID;
@Entity
@Table(name="candidate_skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateSkill {
    private String more_infos;
    private SkillLevel skill_level;
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Id
    @OneToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;

//    public UUID getIdSkill() {
//        return skill.getSkill_id();
//    }
//
//    public void setIdSkill(UUID skillID) {
//        this.skill = new Skill(skillID);
//    }
//    public UUID getIdCandidate() {
//        return candidate.getId();
//    }
//
//    public void setIdCandidate(UUID candidateID) {
//        this.candidate = new Candidate(candidateID);
//    }
}
