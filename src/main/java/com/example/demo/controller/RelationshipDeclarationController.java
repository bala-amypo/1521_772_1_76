package com.example.demo.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.example.demo.model.RelationshipDeclaration;
import com.example.demo.service.RelationshipDeclarationService;

@RestController
@RequestMapping("/api/relationships")
   public class  RelationshipDeclarationController
   {
      @Autowired
      RelationshipDeclarationService ser;
       @PostMapping
          public RelationshipDeclaration declareRelationship(@RequestBody  RelationshipDeclaration ss)
          {
               return ser.declareRelationship(ss);
          }
       @GetMapping("/person/{personId}")
           public List<RelationshipDeclaration> getDeclarationsByPerson(@PathVariable Long personId)
          {
               return ser.getDeclarationsByPerson( personId);
          }
       @PutMapping("/{id}/verify")
          public RelationshipDeclaration verifyDeclaration(@PathVariable("id") Long declaratoinId,@RequestParam Boolean verified)
          {
               return ser.verifyDeclaration(declaratoinId,verified);
          }
       @GetMapping
          public List<RelationshipDeclaration> getAllDeclarations ()
          {
               return ser.getAllDeclarations();
          }
   }