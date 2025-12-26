package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;


@RestController
@RequestMapping("/api/engagements")

public class VendorEngagementController{
    @Autowired
    VendorEngagementService  ser;
    @PostMapping
          public VendorEngagementRecord addEngagement(@RequestBody  VendorEngagementRecord record)
          {
               return ser.addEngagement(record);
          }
    @GetMapping("/employee/{employeeId}")
        public List<VendorEngagementRecord>getEngagementsByEmployee(@PathVariable Long employeeId){
              return ser.getEngagementsByEmployee(employeeId);
        }
    @GetMapping("/vendor/{vendorId}")
        public List<VendorEngagementRecord>getEngagementsByVendor(@PathVariable Long vendorId){
              return ser.getEngagementsByVendor(vendorId);
        }
    @GetMapping
        public List<VendorEngagementRecord>getAllEngagements(){
              return ser.getAllEngagements();
        }

}