package iuh.huynhhoangphuc_21036541_quanlyxe.dao;

import iuh.huynhhoangphuc_21036541_quanlyxe.models.Xe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.stream.Collectors;

public class QuanLyXeDAO {
    private EntityManager em;
    private EntityTransaction et;

    public QuanLyXeDAO() {
        em = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
        et = em.getTransaction();
    }

    public void close() {
        em.close();
    }

    public List<Xe> getAllXe() {
        return em.createQuery("SELECT x FROM Xe x", Xe.class).getResultList();
    }

    public Xe addXe(Xe xe) {
        try {
            et.begin();
            em.persist(xe);
            et.commit();
            return xe;
        } catch (Exception e) {
            et.rollback();
            return null;
        }
    }

    public List<Xe> getDSXeTheoLoai(int maloai) {
        return em.createQuery("SELECT x FROM Xe x WHERE x.maloai.maloai = :maloai", Xe.class)
                .setParameter("maloai", maloai)
                .getResultStream()
                .collect(Collectors.toList());
    }


}
