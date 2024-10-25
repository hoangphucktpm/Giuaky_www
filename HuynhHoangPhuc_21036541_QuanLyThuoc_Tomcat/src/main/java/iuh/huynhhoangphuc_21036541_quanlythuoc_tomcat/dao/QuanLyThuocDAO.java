package iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.dao;

import iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.models.Thuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.stream.Collectors;

public class QuanLyThuocDAO {
    private EntityManager em;
    private EntityTransaction et;

    public QuanLyThuocDAO() {
        em = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
        et = em.getTransaction();
    }

    public void close() {
        em.close();
    }

    public List<Thuoc> getAllThuoc() {
        return em.createQuery("SELECT t FROM Thuoc t", Thuoc.class)
                .getResultStream()
                .collect(Collectors.toList());
    }

    public List<Thuoc> getThuocByLoai(int maloai) {
        return em.createQuery("SELECT t FROM Thuoc t WHERE t.maloai.id = :maloai", Thuoc.class)
                .setParameter("maloai", maloai)
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
}
