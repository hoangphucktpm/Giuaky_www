package iuh.huynhhoangphuc_21036541_candidate.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ExperienceRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public ExperienceRepository() {
        entityManager = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void close() {
        entityManager.close();
    }
}
