package iuh.huynhhoangphuc_21036541_quanlythuoc.dao;

import iuh.huynhhoangphuc_21036541_quanlythuoc.models.LoaiThuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.stream.Collectors;

public class QuanLyLoaiThuocDAO {
    private EntityManager em;
    private EntityTransaction et;

    public QuanLyLoaiThuocDAO() {
        em = Persistence.createEntityManagerFactory("MariaBD").createEntityManager();
        et = em.getTransaction();
    }

    public void close() {
        em.close();
    }

    public List<LoaiThuoc> getAllLoaiThuoc() {
        return em.createQuery("SELECT l FROM LoaiThuoc l", LoaiThuoc.class)
                .getResultStream()
                .collect(Collectors.toList());
    }
}
