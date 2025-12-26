package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictCase;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.service.ConflictCaseService;

import java.util.List;

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
}
