package com.example.demo.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.RelationshipDeclaration;
@Repository
public interface RelationshipDeclarationRepository extends JpaRepository <RelationshipDeclaration,Long>{
    List<RelationshipDeclaration>findByPersonId(Long personId);
}