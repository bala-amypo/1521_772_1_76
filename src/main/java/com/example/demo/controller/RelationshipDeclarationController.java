package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService service;

    public RelationshipDeclarationController(
            RelationshipDeclarationService service) {
        this.service = service;
    }

    // POST /api/relationships
    @PostMapping
    public RelationshipDeclaration declare(
            @RequestBody RelationshipDeclaration declaration) {
        return service.declareRelationship(declaration);
    }

    // GET /api/relationships/person/{personId}
    @GetMapping("/person/{personId}")
    public List<RelationshipDeclaration> getByPerson(
            @PathVariable Long personId) {
        return service.getDeclarationsByPerson(personId);
    }

    // PUT /api/relationships/{id}/verify?verified=true
    @PutMapping("/{id}/verify")
    public RelationshipDeclaration verify(
            @PathVariable Long id,
            @RequestParam boolean verified) {
        return service.verifyDeclaration(id, verified);
    }

    // GET /api/relationships
    @GetMapping
    public List<RelationshipDeclaration> getAll() {
        return service.getAllDeclarations();
    }
}
