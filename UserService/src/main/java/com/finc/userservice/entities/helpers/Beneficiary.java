package com.finc.userservice.entities.helpers;

import jakarta.persistence.Embeddable;

import java.time.LocalDate;

@Embeddable
public class Beneficiary {
    private String beneficiaryId;
    private String name;
    private String accountNumber;
    private String bankCode;
    private String relationship; // FAMILY, BUSINESS, etc.
    private LocalDate addedOn;
}
