package com.example.demo.service.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import com.example.demo.repository.ConflictCaseRepository;
import com.example.demo.repository.ConflictFlagRepository;

import com.example.demo.exception.ApiException;


@Service
public class ConflictCaseServiceImpl implements ConflictCaseService
{
    private final ConflictCaseRepository rep;
    private final ConflictFlagRepository flagRepo;

    public ConflictCaseServiceImpl(ConflictCaseRepository rep,ConflictFlagRepository flagRepo) {
        this.rep = rep;
        this.flagRepo = flagRepo;
    }

    @Override
    public ConflictCase createCase(ConflictCase conflictCase)
    {
        return rep.save(conflictCase);
    }

    @Override
    public ConflictCase updateCaseStatus(Long caseId, String status) {

        ConflictCase ss = rep.findById(caseId)
                .orElseThrow(() -> new ApiException("case not found"));

        ss.setStatus(status);
        return rep.save(ss);
    }


    @Override
    public List<ConflictCase> getCasesByPerson(Long personId) {
        return rep.findByPrimaryPersonIdOrSecondaryPersonId(personId, personId);
    }

    @Override
    public Optional<ConflictCase> getCaseById(Long id) {
        return rep.findById(id);
    }

    @Override
    public List<ConflictCase> getAllCases()
    {
        return rep.findAll();
    }
}