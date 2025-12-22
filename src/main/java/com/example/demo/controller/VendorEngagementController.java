package com.example.demo.controller;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/engagements")
public class VendorEngagementController {

    private final VendorEngagementService service;

    public VendorEngagementController(
            VendorEngagementService service) {
        this.service = service;
    }

    // POST /api/engagements
    @PostMapping
    public VendorEngagementRecord add(
            @RequestBody VendorEngagementRecord record) {
        return service.addEngagement(record);
    }

    // GET /api/engagements/employee/{employeeId}
    @GetMapping("/employee/{employeeId}")
    public List<VendorEngagementRecord> getByEmployee(
            @PathVariable Long employeeId) {
        return service.getEngagementsByEmployee(employeeId);
    }

    // GET /api/engagements/vendor/{vendorId}
    @GetMapping("/vendor/{vendorId}")
    public List<VendorEngagementRecord> getByVendor(
            @PathVariable Long vendorId) {
        return service.getEngagementsByVendor(vendorId);
    }

    // GET /api/engagements
    @GetMapping
    public List<VendorEngagementRecord> getAll() {
        return service.getAllEngagements();
    }
}
