package iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "thuoc")
public class Thuoc {
    @Id
    @Column(name = "mathuoc", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "tenthuoc", nullable = false)
    private String tenthuoc;

    @NotNull
    @Column(name = "gia", nullable = false)
    private Double gia;

    @NotNull
    @Column(name = "namsx", nullable = false)
    private Integer namsx;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "maloai", nullable = false)
    private Loaithuoc maloai;

}