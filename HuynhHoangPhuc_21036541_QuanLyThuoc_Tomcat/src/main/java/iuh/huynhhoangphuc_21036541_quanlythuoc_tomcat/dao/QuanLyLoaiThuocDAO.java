package iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.dao;

import iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.models.Loaithuoc;
import iuh.huynhhoangphuc_21036541_quanlythuoc_tomcat.models.Thuoc;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.stream.Collectors;

public class QuanLyLoaiThuocDAO {
    private EntityManager em;
    private EntityTransaction et;

    public QuanLyLoaiThuocDAO() {
        em = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
        et = em.getTransaction();
    }

    public void close() {
        em.close();
    }

    public List<Loaithuoc> getAllLoaiThuoc() {
        return em.createQuery("SELECT t FROM Loaithuoc t", Loaithuoc.class)
                .getResultStream()
                .collect(Collectors.toList());
    }
}
