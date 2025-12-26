package com.example.demo.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;
@Entity
public class RelationshipDeclaration{
    @Id
    private Long id;
    private Long personId;
    private String relatedPersonName;
    private String relationshipType;
    private String description;
    private LocalDateTime declaredAt;
    private Boolean isVerified=false;
     public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getPersonId() {
        return personId;
    }
    public void setPersonId(Long personId) {
        this.personId = personId;
    }
    public String getRelatedPersonName() {
        return relatedPersonName;
    }
    public void setRelatedPersonName(String relatedPersonName) {
        this.relatedPersonName = relatedPersonName;
    }
    public String getRelationshipType() {
        return relationshipType;
    }
    public void setdescription(String description) {
        this.description=description;
    }
    public String getdescription() {
        return description;
        }
    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }
    public LocalDateTime getDeclaredAt() {
        return declaredAt;
    }
    public void setDeclaredAt(LocalDateTime declaredAt) {
        this.declaredAt = declaredAt;
    }
    public Boolean getIsVerified() {
        return isVerified;
    }
    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }
    public RelationshipDeclaration(Long id, Long personId, String relatedPersonName, String relationshipType, LocalDateTime declaredAt,
            Boolean isVerified) {
        this.id = id;
        this.personId = personId;
        this.relatedPersonName = relatedPersonName;
        this.relationshipType = relationshipType;
        this.declaredAt = declaredAt;
        this.isVerified = isVerified;
    }
    public RelationshipDeclaration() {
    }
    
}