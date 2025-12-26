package com.example.demo.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.ConflictFlag;


@Repository
public interface ConflictFlagRepository extends JpaRepository <ConflictFlag,Long>{
    List<ConflictFlag>findByCaseId(Long caseId);
}