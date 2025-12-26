package com.example.demo.controller;

import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relationships")
public class RelationshipDeclarationController {

    private final RelationshipDeclarationService service;

    public RelationshipDeclarationController(
            RelationshipDeclarationService service) {
        this.service = service;
    }

    @PostMapping
    public RelationshipDeclaration create(
            @RequestBody RelationshipDeclaration rd) {
        return service.create(rd);
    }

    @GetMapping("/{id}")
    public RelationshipDeclaration get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/person/{personId}")
    public List<RelationshipDeclaration> byPerson(
            @PathVariable Long personId) {
        return service.getByPersonId(personId);
    }
}
