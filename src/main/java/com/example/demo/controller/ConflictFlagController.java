package com.example.demo.controller;

import com.example.demo.model.ConflictFlag;
import com.example.demo.service.impl.ConflictFlagServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flags")
public class ConflictFlagController {

    private final ConflictFlagServiceImpl service;

    public ConflictFlagController(ConflictFlagServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public ConflictFlag addFlag(@RequestBody ConflictFlag flag) {
        return service.addFlag(flag);
    }

    @GetMapping("/{id}")
    public ConflictFlag getFlag(@PathVariable Long id) {
        return service.getFlagById(id);
    }

    @GetMapping("/case/{id}")
    public List<ConflictFlag> getByCase(@PathVariable Long id) {
        return service.getFlagsByCase(id);
    }
}
