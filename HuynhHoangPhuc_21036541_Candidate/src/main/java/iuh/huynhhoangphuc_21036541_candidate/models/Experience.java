package iuh.huynhhoangphuc_21036541_candidate.models;

import iuh.huynhhoangphuc_21036541_candidate.enums.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "experience")
public class Experience {
    @Id
    @Column(name = "exp_id")
    private long id;

    @Column(name = "from_date")
    private LocalDate fromDate;

    @Column(name = "to_date")
    private LocalDate toDate;

    @Column(name = "company")
    private String companyName;

    @Column(name = "work_desc")
    private String workDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Roles role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "can_id")
    private Candidate candidate;

}
