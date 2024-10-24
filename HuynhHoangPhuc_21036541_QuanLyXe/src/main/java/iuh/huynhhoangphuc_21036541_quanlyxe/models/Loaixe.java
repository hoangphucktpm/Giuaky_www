package iuh.huynhhoangphuc_21036541_quanlyxe.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "loaixe")
public class Loaixe {
    @Id
    @Column(name = "maloai")
    private Integer maloai;

    @Size(max = 255)
    @Column(name = "tenloai")
    private String tenloai;

}