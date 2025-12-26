package com.example.demo.controller;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
@RestController
@RequestMapping("/api/persons")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<PersonProfile> create(@RequestBody PersonProfile p) {
        return ResponseEntity.ok(service.createPerson(p));
    }

    @GetMapping
    public ResponseEntity<List<PersonProfile>> getAll() {
        return ResponseEntity.ok(service.getAllPersons());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<PersonProfile>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                Optional.of(service.getPersonById(id))
        );
    }
    @GetMapping("/lookup/{refId}")
    public ResponseEntity<Optional<PersonProfile>> lookup(@PathVariable String refId) {

        Optional<PersonProfile> person = service.findByReferenceId(refId);

        if (person.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(person);
    }


    @PutMapping("/{id}/relationship")
    public ResponseEntity<PersonProfile> toggleRelationshipDeclared(
            @PathVariable Long id,
            @RequestParam boolean declared) {

        return ResponseEntity.ok(
                service.updateRelationshipDeclared(id, declared)
        );
    }
}