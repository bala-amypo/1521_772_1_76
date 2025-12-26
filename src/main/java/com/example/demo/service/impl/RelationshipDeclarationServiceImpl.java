package com.example.demo.service.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;

import com.example.demo.exception.ApiException;

import com.example.demo.repository.RelationshipDeclarationRepository;
import com.example.demo.repository.PersonProfileRepository; 
@Service


public class RelationshipDeclarationServiceImpl implements RelationshipDeclarationService{
    

    private final RelationshipDeclarationRepository rep;
    private final PersonProfileRepository persrep;

    public RelationshipDeclarationServiceImpl(RelationshipDeclarationRepository rep,PersonProfileRepository persrep)
    {
        this.rep = rep;
        this.persrep = persrep;
    }

    @Override
    public RelationshipDeclaration declareRelationship(RelationshipDeclaration ss)
    {
        if (ss.getPersonId() == null ||
            persrep.findById(ss.getPersonId()).isEmpty()) {

            throw new ApiException("person not found");
        }

        return rep.save(ss);
    }

    @Override
    public List<RelationshipDeclaration> getDeclarationsByPerson(Long personId)
    {
        return rep.findByPersonId(personId); 
    }
    @Override
    public RelationshipDeclaration verifyDeclaration(Long id, Boolean verified)
    {
        RelationshipDeclaration ss = rep.findById(id)
                .orElseThrow(() -> new ApiException("declaration not found"));

        ss.setIsVerified(verified);
        return rep.save(ss);
    }

     @Override
    public List<RelationshipDeclaration> getAllDeclarations()
    {
        return rep.findAll(); 
    }
}