package iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "loaithuoc")
public class Loaithuoc {
    @Id
    @Column(name = "maloai", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "tenloai", nullable = false)
    private String tenloai;

}