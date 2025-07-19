package com.finc.userservice.entities.helpers;

import java.time.LocalDate;

public class KYCDocument {
    private String documentType;//ID_PROOF, PROOF_OF_ADDRESS
    private String storageReference; //S3 path or Azure Blob
    private LocalDate uploadDate;
    private String uploadedBy; //ADMIN
}
