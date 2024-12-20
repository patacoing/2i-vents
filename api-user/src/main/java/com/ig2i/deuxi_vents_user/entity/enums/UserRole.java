package com.ig2i.deuxi_vents_user.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum UserRole {
    ADMIN("ADMIN"),
    PARTICIPANT("PARTICIPANT"),
    ORGANISATEUR("ORGANISATEUR");
    private final String label;

    UserRole(String label) {
        this.label = label;
    }
}
