package com.example.demo.service.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ConflictFlag;
import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictFlagService;
import com.example.demo.repository.ConflictFlagRepository;
import com.example.demo.repository.ConflictCaseRepository;

import com.example.demo.exception.ApiException;


@Service

public class ConflictFlagServiceImpl implements ConflictFlagService
{

    
    private final ConflictFlagRepository rep;
    private final ConflictCaseRepository caseRepo;

    public ConflictFlagServiceImpl(ConflictFlagRepository rep,ConflictCaseRepository caseRepo) {
        this.rep = rep;
        this.caseRepo = caseRepo;
    }


    @Override
    public ConflictFlag addFlag(ConflictFlag flag)
    {
        if (flag.getCaseId() == null) {
            throw new ApiException("conflict case not found");
        }

        ConflictCase conflictCase = caseRepo.findById(flag.getCaseId())
                .orElseThrow(() -> new ApiException("conflict case not found"));

        if ("HIGH".equalsIgnoreCase(flag.getSeverity())) {
            conflictCase.setRiskLevel("HIGH");
            caseRepo.save(conflictCase);
        }

        return rep.save(flag);
    }


    @Override
    public List<ConflictFlag> getFlagsByCase(Long caseId)
    {
        return rep.findByCaseId(caseId);
    }
    @Override
    public ConflictFlag getFlagById(Long id)
    {
        return rep.findById(id)
                .orElseThrow(() -> new ApiException("flag not found"));
    }

    @Override
    public List<ConflictFlag> getAllFlags()
    {
        return rep.findAll();
    }
}