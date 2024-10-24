package iuh.huynhhoangphuc_21036541_candidate.services;

import iuh.huynhhoangphuc_21036541_candidate.enums.Roles;
import iuh.huynhhoangphuc_21036541_candidate.models.Candidate;
import iuh.huynhhoangphuc_21036541_candidate.repositories.CandidateRepository;

import java.util.List;

public class CandidateService {
    private CandidateRepository candidateRepository;

    public CandidateService() {
        this.candidateRepository = new CandidateRepository();
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.getAllCandidates();
    }

    public Candidate getCandidateById(long id) {
        return candidateRepository.getCandidateById(id);
    }

    public List<Candidate> getCandidatesByCompanyAndRole(String company, String role) {
        return candidateRepository.getCandidatesByCompanyAndRole(company, role);
    }

    public List<Candidate> getCandidatesWithAtLeastFiveYearsExperience() {
        return candidateRepository.getCandidatesWithAtLeastFiveYearsExperience();
    }

    public List<Candidate> getCandidatesByRole(Roles role) {
        return candidateRepository.getCandidatesByRole(role);
    }

    public List<Candidate> getCandidatesUsingGmail() {
        return candidateRepository.getCandidatesUsingGmail();
    }
}