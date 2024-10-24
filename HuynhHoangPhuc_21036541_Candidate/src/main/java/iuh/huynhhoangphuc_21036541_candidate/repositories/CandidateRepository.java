package iuh.huynhhoangphuc_21036541_candidate.repositories;

import iuh.huynhhoangphuc_21036541_candidate.enums.Roles;
import iuh.huynhhoangphuc_21036541_candidate.models.Candidate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.stream.Collectors;

public class CandidateRepository {
    private EntityManager entityManager;
    private EntityTransaction transaction;

    public CandidateRepository() {
        entityManager = Persistence.createEntityManagerFactory("MariaDB").createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void close() {
        entityManager.close();
    }

    public List<Candidate> getAllCandidates() {
        return entityManager.createQuery("SELECT c FROM Candidate c", Candidate.class)
                .getResultStream()
                .collect(Collectors.toList());
    }

    public Candidate getCandidateById(long id) {
        return entityManager.find(Candidate.class, id);
    }

    public List<Candidate> getCandidatesByCompanyAndRole(String company, String role) {
        return entityManager.createQuery("SELECT DISTINCT c FROM Candidate c JOIN c.experiences e WHERE e.companyName = :company AND e.role = :role", Candidate.class)
                .setParameter("company", company)
                .setParameter("role", role)
                .getResultList();
    }

    public List<Candidate> getCandidatesWithAtLeastFiveYearsExperience() {
        return entityManager.createQuery("SELECT DISTINCT c FROM Candidate c JOIN c.experiences e WHERE e.fromDate <= CURRENT_DATE - 1825", Candidate.class)
                .getResultList();
    }

    public List<Candidate> getCandidatesByRole(Roles role) {
        return entityManager.createQuery("SELECT DISTINCT c FROM Candidate c JOIN c.experiences e WHERE e.role = :role", Candidate.class)
                .setParameter("role", role)
                .getResultList();
    }

    public List<Candidate> getCandidatesUsingGmail() {
        return entityManager.createQuery("SELECT c FROM Candidate c WHERE c.email LIKE '%@gmail.com'", Candidate.class)
                .getResultList();
    }


}