package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_profiles",
       uniqueConstraints = {
         @UniqueConstraint(columnNames = "email"),
         @UniqueConstraint(columnNames = "referenceId")
       })
public class PersonProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String personType;
    private String referenceId;
    private String fullName;
    private String email;
    private String department;
    private Boolean relationshipDeclared = false;
    private LocalDateTime createdAt = LocalDateTime.now();

    // getters & setters
}
