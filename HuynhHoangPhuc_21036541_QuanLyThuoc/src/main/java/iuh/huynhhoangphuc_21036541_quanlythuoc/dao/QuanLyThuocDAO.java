package iuh.huynhhoangphuc_21036541_quanlythuoc.dao;

import iuh.huynhhoangphuc_21036541_quanlythuoc.models.Thuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.stream.Collectors;

public class QuanLyThuocDAO {
    private EntityManager em;
    private EntityTransaction et;

    public QuanLyThuocDAO() {
        em = Persistence.createEntityManagerFactory("MariaBD").createEntityManager();
        et = em.getTransaction();
    }

    public List<Thuoc> getAllThuoc() {
        return em.createQuery("SELECT t FROM Thuoc t", Thuoc.class)
                .getResultStream()
                .collect(Collectors.toList());
    }

    public Thuoc add(Thuoc thuoc) {
        try {
            et.begin();
            em.persist(thuoc);
            et.commit();
            return thuoc;
        } catch (Exception e) {
            et.rollback();
            return null;
        }
    }

    public List<Thuoc> getDSThuocByLoaiThuoc(String loaiThuoc) {
        return em.createQuery("SELECT t FROM Thuoc t WHERE t.maLoai.maLoai = :loaiThuoc", Thuoc.class)
                .setParameter("loaiThuoc", loaiThuoc)
                .getResultStream()
                .collect(Collectors.toList());
    }

    public void close() {
        em.close();
    }


}
