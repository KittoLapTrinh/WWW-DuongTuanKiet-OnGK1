package vn.edu.iuh.fit.wwwduongtuankietgk1.services.impl;

import vn.edu.iuh.fit.wwwduongtuankietgk1.models.Candidate;
import vn.edu.iuh.fit.wwwduongtuankietgk1.repositories.CandidateRepository;
import vn.edu.iuh.fit.wwwduongtuankietgk1.services.CandidateService;

import java.util.List;
import java.util.Optional;

public class CandidateServiceImpl implements CandidateService {
    private final CandidateRepository repository;

    public CandidateServiceImpl(){
        repository = new CandidateRepository();
    }
    @Override
    public List<Candidate> getAllCandidate() {
        return repository.getAll(Candidate.class);
    }

    @Override
    public Candidate getCandidateDetail(long id) throws Exception {
        Optional<Candidate> candidate = repository.get(Candidate.class, id);
        if(candidate.isEmpty())
            throw new Exception("Not found");
        return candidate.get();

    }

    @Override
    public boolean insert(Candidate candidate) {
        return repository.insert(candidate);
    }


    @Override
    public List<Candidate> findCandidateBySkillLevel(int skillLevel) {
        return repository.findCandidateByLevel(skillLevel);
    }

    @Override
    public List<Candidate> findCandidateHasEmail() {
        return repository.findCandidateHasEmail();
    }
}
