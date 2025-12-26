package com.example.demo.service.impl;

import com.example.demo.exception.ApiException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.VendorEngagementService;

import java.util.List;

public class VendorEngagementServiceImpl implements VendorEngagementService {

    private final VendorEngagementRecordRepository repo;
    private final PersonProfileRepository personRepo;

    public VendorEngagementServiceImpl(
            VendorEngagementRecordRepository repo,
            PersonProfileRepository personRepo) {
        this.repo = repo;
        this.personRepo = personRepo;
    }

    @Override
    public VendorEngagementRecord addEngagement(VendorEngagementRecord r) {
        if (personRepo.findById(r.getEmployeeId()).isEmpty())
            throw new ApiException("Employee not found");
        if (personRepo.findById(r.getVendorId()).isEmpty())
            throw new ApiException("Vendor not found");
        return repo.save(r);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByEmployee(Long id) {
        return repo.findByEmployeeId(id);
    }

    @Override
    public List<VendorEngagementRecord> getEngagementsByVendor(Long id) {
        return repo.findByVendorId(id);
    }

    @Override
    public List<VendorEngagementRecord> getAllEngagements() {
        return repo.findAll();
    }
}
