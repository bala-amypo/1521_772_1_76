package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ConflictCaseService;

import java.util.*;

public class ConflictCaseServiceImpl implements ConflictCaseService {

    private final ConflictCaseRepository repo;
    private final ConflictFlagRepository flagRepo;

    public ConflictCaseServiceImpl(
            ConflictCaseRepository repo,
            ConflictFlagRepository flagRepo) {
        this.repo = repo;
        this.flagRepo = flagRepo;
    }

    @Override
    public ConflictCase createCase(ConflictCase c) {
        if (c.getStatus() == null) c.setStatus("OPEN");
        return repo.save(c);
    }

    @Override
    public ConflictCase updateCaseStatus(Long id, String status) {
        ConflictCase c = repo.findById(id)
                .orElseThrow(() -> new ApiException("Case not found"));
        c.setStatus(status);
        return repo.save(c);
    }

    @Override
    public List<ConflictCase> getAllCases() {
        return repo.findAll();
    }

    @Override
    public Optional<ConflictCase> getCaseById(Long id) {
        return repo.findById(id);
    }

    @Override
    public List<ConflictCase> getCasesByPerson(Long id) {
        return repo.findByPrimaryPersonIdOrSecondaryPersonId(id, id);
    }
}
