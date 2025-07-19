package com.finc.userservice.entities;

import com.finc.userservice.enums.IdentificationType;
import com.finc.userservice.enums.VerificationStatus;

import java.time.LocalDate;

public class KYCDetails {
    private IdentificationType governmentIdType;
    private String governmentIdentificationNumber;

    //Verification Status
    private VerificationStatus verificationStatus = VerificationStatus.PENDING;

}
