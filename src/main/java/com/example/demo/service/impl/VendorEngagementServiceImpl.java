package com.example.demo.service.impl;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.VendorEngagementRecord;
import com.example.demo.service.VendorEngagementService;
import com.example.demo.repository.VendorEngagementRecordRepository;
import com.example.demo.repository.PersonProfileRepository;
import com.example.demo.exception.ApiException;

@Service

public class VendorEngagementServiceImpl implements VendorEngagementService
{
    
    private final VendorEngagementRecordRepository rep;
    private final PersonProfileRepository persrep;

    public VendorEngagementServiceImpl(VendorEngagementRecordRepository rep, PersonProfileRepository persrep){
        this.rep = rep;
        this.persrep = persrep;
    }
    
    @Override
    public VendorEngagementRecord addEngagement(VendorEngagementRecord record)
    {
        if (record.getEmployeeId() == null ||
            persrep.findById(record.getEmployeeId()).isEmpty()) {

            throw new ApiException("employee not found");
        }

        return rep.save(record);
    }

       @Override
    public List<VendorEngagementRecord>getEngagementsByEmployee(Long employeeId)
    {
        return rep.findByEmployeeId(employeeId);
    }
       @Override
    public List<VendorEngagementRecord>getEngagementsByVendor(Long vendorId)
    {
        return rep.findByVendorId(vendorId);
    }
       @Override
    public List<VendorEngagementRecord>getAllEngagements()
    {
        return rep.findAll();
    }
}