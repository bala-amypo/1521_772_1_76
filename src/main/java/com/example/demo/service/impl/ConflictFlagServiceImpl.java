package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ConflictFlagService;

import java.util.List;

public class ConflictFlagServiceImpl implements ConflictFlagService {

    private final ConflictFlagRepository repo;
    private final ConflictCaseRepository caseRepo;

    public ConflictFlagServiceImpl(
            ConflictFlagRepository repo,
            ConflictCaseRepository caseRepo) {
        this.repo = repo;
        this.caseRepo = caseRepo;
    }

    @Override
    public ConflictFlag addFlag(ConflictFlag f) {
        ConflictCase c = caseRepo.findById(f.getCaseId())
                .orElseThrow(() -> new ApiException("ConflictCase not found"));

        if ("HIGH".equalsIgnoreCase(f.getSeverity())) {
            c.setRiskLevel("HIGH");
            caseRepo.save(c);
        }
        return repo.save(f);
    }

    @Override
    public ConflictFlag getFlagById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Flag not found"));
    }

    @Override
    public List<ConflictFlag> getFlagsByCase(Long id) {
        return repo.findByCaseId(id);
    }

    @Override
    public List<ConflictFlag> getAllFlags() {
        return repo.findAll();
    }
}
