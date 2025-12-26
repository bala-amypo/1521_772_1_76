package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.*;
import java.util.*;

public interface PersonProfileRepository extends JpaRepository<PersonProfile, Long> {
    Optional<PersonProfile> findByEmail(String email);
    Optional<PersonProfile> findByReferenceId(String referenceId);
}

public interface RelationshipDeclarationRepository
        extends JpaRepository<RelationshipDeclaration, Long> { }

public interface VendorEngagementRecordRepository
        extends JpaRepository<VendorEngagementRecord, Long> {
    List<VendorEngagementRecord> findByEmployeeId(Long id);
    List<VendorEngagementRecord> findByVendorId(Long id);
}

public interface ConflictCaseRepository
        extends JpaRepository<ConflictCase, Long> {
    List<ConflictCase> findByPrimaryPersonIdOrSecondaryPersonId(Long p, Long s);
}

public interface ConflictFlagRepository
        extends JpaRepository<ConflictFlag, Long> {
    List<ConflictFlag> findByCaseId(Long id);
}
