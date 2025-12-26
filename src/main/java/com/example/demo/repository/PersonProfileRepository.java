package com.example.demo.repository;

import java.util.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.PersonProfile;
@Repository
public interface PersonProfileRepository extends JpaRepository <PersonProfile,Long>{
    Optional<PersonProfile>findByReferenceId(String referenceId);
    Optional<PersonProfile> findByEmail(String email);
}