package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.impl.VendorEngagementServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engagements")
public class VendorEngagementController {

    private final VendorEngagementServiceImpl service;

    public VendorEngagementController(
            VendorEngagementServiceImpl service) {
        this.service = service;
    }

    @PostMapping
    public VendorEngagementRecord addEngagement(
            @RequestBody VendorEngagementRecord record) {
        return service.addEngagement(record);
    }

    @GetMapping("/employee/{id}")
    public List<VendorEngagementRecord> byEmployee(
            @PathVariable Long id) {
        return service.getEngagementsByEmployee(id);
    }

    @GetMapping("/vendor/{id}")
    public List<VendorEngagementRecord> byVendor(
            @PathVariable Long id) {
        return service.getEngagementsByVendor(id);
    }
}
