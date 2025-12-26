package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.RelationshipDeclarationService;

import java.util.List;

public class RelationshipDeclarationServiceImpl
        implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository repo;
    private final PersonProfileRepository personRepo;

    public RelationshipDeclarationServiceImpl(
            RelationshipDeclarationRepository repo,
            PersonProfileRepository personRepo) {
        this.repo = repo;
        this.personRepo = personRepo;
    }

    @Override
    public RelationshipDeclaration declareRelationship(RelationshipDeclaration d) {
        PersonProfile p = personRepo.findById(d.getPersonId())
                .orElseThrow(() -> new ApiException("Person not found"));
        p.setRelationshipDeclared(true);
        personRepo.save(p);
        return repo.save(d);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(Long id, boolean flag) {
        RelationshipDeclaration d = repo.findById(id)
                .orElseThrow(() -> new ApiException("Declaration not found"));
        d.setIsVerified(flag);
        return repo.save(d);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return repo.findAll();
    }
}
