package iuh.huynhhoangphuc_21036541_quanlyxe.dao;

import iuh.huynhhoangphuc_21036541_quanlyxe.models.Loaixe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.stream.Collectors;

public class QuanLyLoaiXeDAO {
    private EntityManager em;
    private EntityTransaction et;

    public QuanLyLoaiXeDAO() {
        em = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
        et = em.getTransaction();
    }

    public void close() {
        em.close();
    }

    public List<Loaixe> getAllLoaiXe() {
        return em.createQuery("SELECT l FROM Loaixe l", Loaixe.class)
                .getResultStream()
                .collect(Collectors.toList());
    }






}
