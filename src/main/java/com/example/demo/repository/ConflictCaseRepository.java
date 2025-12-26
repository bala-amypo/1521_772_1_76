package com.example.demo.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ConflictCase;

@Repository
public interface ConflictCaseRepository extends JpaRepository <ConflictCase,Long>{
    
    List<ConflictCase> findByPrimaryPersonIdOrSecondaryPersonId(
            Long primaryPersonId,
            Long secondaryPersonId
    );
}