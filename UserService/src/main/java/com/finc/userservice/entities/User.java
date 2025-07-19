package com.finc.userservice.entities;


import com.finc.userservice.entities.helpers.Beneficiary;
import com.finc.userservice.entities.helpers.KYCDetails;
import com.finc.userservice.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "User",
indexes = {
        @Index(name = "idx_user_email", columnList = "email", unique = true),
        @Index(name="idx_user_phone", columnList = "phoneNumber", unique = true),
        @Index(name = "idx_user_customerId", columnList = "customerId", unique = true)
})
public class User {
    //Core identification
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    //Bank-Generated
    @Column(nullable = false, updatable = false)
    private String customerId;
    @Column(nullable = false, unique = true)
    private String accountNumber;
    //Personal Information
    private String title;
    private String fullName;
    //contact details
    @Column(unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    //Demographics
    private Gender gender;
    private MaritalStatus maritalStatus;
    private LocalDate dateOfBirth;
    //Address (OneToMany) for address history
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Address> addresses = new ArrayList<>();
    //KYC
    @Embedded
    private KYCDetails kycDetails;

    //Account Status
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.PENDING;
    @Enumerated(EnumType.STRING)
    private AccountTier accountTier = AccountTier.STANDARD;

    // Banking Relationships
    @ElementCollection
    @CollectionTable(name = "user_beneficiaries", joinColumns = @JoinColumn(name = "user_id"))
    private HashSet<Beneficiary> beneficiaries = new HashSet<>();

    //Metadata
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime lastModifiedAt;
    private String createdBy; // "SYSTEM" or Admin ID
    private String modifiedBy;
    //Version
    private Long version;

    public void markAsVerified(){
        this.status = UserStatus.ACTIVE;
        this.kycDetails.setVerificationStatus(VerificationStatus.VERIFIED);
    }
}
