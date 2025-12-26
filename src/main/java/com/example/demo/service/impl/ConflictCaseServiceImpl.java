package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.service.ConflictCaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔥 THIS IS THE FIX
public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository repo;

    public ConflictCaseServiceImpl(ConflictCaseRepository repo) {
        this.repo = repo;
    }

    @Override
    public ConflictCase createCase(ConflictCase conflictCase) {
        return repo.save(conflictCase);
    }

    @Override
    public ConflictCase getCaseById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Case not found"));
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return repo.findAll();
    }

    @Override
    public ConflictCase updateCaseStatus(Long id, String status) {
        ConflictCase c = getCaseById(id);
        c.setStatus(status);
        return repo.save(c);
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return repo.findByPersonId(personId);
    }
}
