package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.PersonProfile;
import com.example.demo.service.PersonProfileService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonProfileController {

    private final PersonProfileService service;

    public PersonProfileController(PersonProfileService service) {
        this.service = service;
    }

    @PostMapping
    public PersonProfile create(@RequestBody PersonProfile person) {
        return service.createPerson(person);
    }
    @GetMapping("/hi")
    public String hi(@RequestParam int id) {
        return "the id is "+id;
    }
    @GetMapping("/hlo")
    public String hlo(@PathVariable int ido,@PathVariable int idt) {
        return "the id is "+ido + "the id is "+idt;
    }

    @GetMapping("/{id}")
    public PersonProfile getById(@PathVariable Long id) {
        return service.getPersonById(id);
    }

    @GetMapping
    public List<PersonProfile> getAll() {
        return service.getAllPersons();
    }
}
