package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.ConflictFlag;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.service.ConflictFlagService;

import java.util.List;

public class ConflictFlagServiceImpl implements ConflictFlagService {

    private final ConflictFlagRepository repo;

    public ConflictFlagServiceImpl(ConflictFlagRepository repo) {
        this.repo = repo;
    }

    @Override
    public ConflictFlag addFlag(ConflictFlag flag) {
        return repo.save(flag);
    }

    @Override
    public ConflictFlag getFlagById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Flag not found"));
    }

    @Override
    public List<ConflictFlag> getFlagsByCaseId(Long caseId) {
        return repo.findByCaseId(caseId);
    }
}
