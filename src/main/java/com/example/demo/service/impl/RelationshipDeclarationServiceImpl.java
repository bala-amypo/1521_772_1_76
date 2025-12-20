package com.example.demo.service.impl;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;
import com.example.demo.exception.ApiException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipDeclarationServiceImpl
        implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository repo;

    public RelationshipDeclarationServiceImpl(
            RelationshipDeclarationRepository repo) {
        this.repo = repo;
    }

    @Override
    public RelationshipDeclaration declareRelationship(
            RelationshipDeclaration declaration) {
        return repo.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId) {
        return repo.findByPersonId(personId);
    }

    @Override
    public RelationshipDeclaration verifyDeclaration(
            Long declarationId, boolean verified) {

        RelationshipDeclaration declaration = repo.findById(declarationId)
                .orElseThrow(() -> new ApiException("Declaration not found"));

        declaration.setIsVerified(verified);
        return repo.save(declaration);
    }

    @Override
    public List<RelationshipDeclaration> getAllDeclarations() {
        return repo.findAll();
    }
}
