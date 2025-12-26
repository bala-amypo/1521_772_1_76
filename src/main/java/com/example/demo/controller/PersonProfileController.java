package com.example.demo.controller;

import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PersonProfile> create(@RequestBody PersonProfile p) {
        return ResponseEntity.ok(service.createPerson(p));
    }

    @GetMapping("/{ref}")
    public ResponseEntity<PersonProfile> lookup(@PathVariable String ref) {
        Optional<PersonProfile> opt = service.findByReferenceId(ref);
        return opt.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
