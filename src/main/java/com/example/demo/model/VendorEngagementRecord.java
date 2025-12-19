package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class VendorEngagementRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;
    private Long vendorId;
    private String engagementType;
    private Double amount;
    private LocalDate engagementDate;
    private String notes;

    // getters & setters
}
