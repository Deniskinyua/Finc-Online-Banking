package com.finc.userservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Address {
    @Id
    @GeneratedValue
    private UUID id;

    private String addressType; //HOME, WORK, MAILING
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String county;
    private String postalCode;
    private String country;

    private boolean isPrimary;
    private LocalDate sinceDate;
}
