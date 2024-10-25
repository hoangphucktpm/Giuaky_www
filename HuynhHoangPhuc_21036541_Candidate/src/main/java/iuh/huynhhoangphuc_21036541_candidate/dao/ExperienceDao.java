package iuh.huynhhoangphuc_21036541_candidate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ExperienceDao {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public ExperienceDao() {
        entityManager = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void close() {
        entityManager.close();
    }
}
