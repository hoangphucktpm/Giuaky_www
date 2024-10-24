package iuh.huynhhoangphuc_21036541_candidate.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.checkerframework.checker.units.qual.N;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "candidate")
public class Candidate {
    @Id
    @Column(name = "can_id")
    private long id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private List<Experience> experiences;

}
