package com.example.demo.service.impl;

import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.service.ConflictCaseService;
import com.example.demo.exception.ApiException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public ConflictCase updateCaseStatus(Long caseId, String status) {
        ConflictCase conflictCase = repo.findById(caseId)
                .orElseThrow(() -> new ApiException("Case not found"));

        conflictCase.setStatus(status);
        return repo.save(conflictCase);
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return repo.findByPrimaryPersonIdOrSecondaryPersonId(
                personId, personId);
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
}
