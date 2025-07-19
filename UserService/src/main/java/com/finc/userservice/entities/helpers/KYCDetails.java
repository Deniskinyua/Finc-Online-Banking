package com.finc.userservice.entities.helpers;

import com.finc.userservice.enums.IdentificationType;
import com.finc.userservice.enums.VerificationStatus;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KYCDetails {
    //Government Details
    private IdentificationType governmentIdType;
    private String governmentIdentificationNumber;

    //Biometric References
    private String biometricReferenceId;

    //Verification Status
    private VerificationStatus verificationStatus = VerificationStatus.PENDING;

    //Risk Assessment
    private String riskRating; //low, medium, high

    private List<KYCDocument> documents = new ArrayList<>();

    //Verification Metadata
    private LocalDateTime verifiedAt;
    private String verifiedBy; // ADMIN ID or AUTO
    private String verificationNotes;

}
