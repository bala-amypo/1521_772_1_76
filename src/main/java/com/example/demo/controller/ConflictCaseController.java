package com.example.demo.controller;

import com.example.demo.model.ConflictCase;
import com.example.demo.service.ConflictCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conflicts")
public class ConflictCaseController {

    private final ConflictCaseService service;

    public ConflictCaseController(ConflictCaseService service) {
        this.service = service;
    }

    @PostMapping
    public ConflictCase createCase(@RequestBody ConflictCase conflictCase) {
        return service.createCase(conflictCase);
    }

    @PutMapping("/{id}/status")
    public ConflictCase updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return service.updateCaseStatus(id, status);
    }

    @GetMapping("/{id}")
    public ConflictCase getCase(@PathVariable Long id) {
        return service.getCaseById(id);
    }

    @GetMapping("/person/{id}")
    public List<ConflictCase> getByPerson(@PathVariable Long id) {
        return service.getCasesByPerson(id);
    }
}
