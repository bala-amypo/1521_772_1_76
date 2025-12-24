package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.impl.RelationshipDeclarationServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationServiceImpl service;

    public RelationshipDeclarationController(
            RelationshipDeclarationServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public RelationshipDeclaration declare(
            @RequestBody RelationshipDeclaration declaration) {
        return service.declareRelationship(declaration);
    }

    @PutMapping("/{id}/verify")
    public RelationshipDeclaration verify(
            @PathVariable Long id,
            @RequestParam boolean verified) {
        return service.verifyDeclaration(id, verified);
    }

    @GetMapping
    public List<RelationshipDeclaration> getAll() {
        return service.getAllDeclarations();
    }
}
