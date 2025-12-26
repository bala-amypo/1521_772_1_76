package com.example.demo.service;
import com.example.demo.model.RelationshipDeclaration;
import java.util.*;
public interface  RelationshipDeclarationService
{
    RelationshipDeclaration declareRelationship(RelationshipDeclaration ss);
    List<RelationshipDeclaration> getDeclarationsByPerson(Long personId);
    RelationshipDeclaration verifyDeclaration(Long declaratoinId, Boolean verified);
    List<RelationshipDeclaration> getAllDeclarations ();
}