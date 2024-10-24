package iuh.huynhhoangphuc_21036541_quanlyxe.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "xe")
public class Xe {
    @Id
    @Column(name = "maxe", nullable = false)
    private Integer maxe;

    @Size(max = 255)
    @Column(name = "tenxe")
    private String tenxe;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "namsx")
    private Integer namsx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maloai", referencedColumnName = "maloai")
    private Loaixe maloai;

}