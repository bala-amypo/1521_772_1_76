package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service   // 🔥 THIS WAS MISSING
public class RelationshipDeclarationServiceImpl
        implements RelationshipDeclarationService {

    private final RelationshipDeclarationRepository repo;

    public RelationshipDeclarationServiceImpl(
            RelationshipDeclarationRepository repo) {
        this.repo = repo;
    }

    @Override
    public RelationshipDeclaration create(RelationshipDeclaration rd) {
        return repo.save(rd);
    }

    @Override
    public RelationshipDeclaration getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ApiException("Declaration not found"));
    }

    @Override
    public List<RelationshipDeclaration> getByPersonId(Long personId) {
        return repo.findByPersonId(personId);
    }
}
