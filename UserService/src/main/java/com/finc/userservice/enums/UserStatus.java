package com.finc.userservice.enums;

public enum UserStatus {
    //Registration
    PENDING, //created but not verified
    VERIFICATION_HOLD,
    ACTIVE, //fully operational

    //Restriction Status
    SUSPENDED, //temporary blocked
    FROZEN,

    //Termination Status
    CLOSED,
    DORMANT,
    BLACKLISTED
}
