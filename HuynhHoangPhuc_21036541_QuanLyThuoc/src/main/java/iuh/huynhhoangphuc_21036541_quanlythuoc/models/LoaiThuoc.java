package iuh.huynhhoangphuc_21036541_quanlythuoc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "loai_thuoc")
public class LoaiThuoc {
    @Id
    @Size(max = 255)
    @Column(name = "ma_loai", nullable = false)
    private String maLoai;

    @Size(max = 255)
    @Column(name = "ten_loai")
    private String tenLoai;

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

}