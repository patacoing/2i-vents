package com.ig2i.deuxi_vents_user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponseDto {
    @JsonProperty("accesstoken")
    private String accessToken;
    @JsonProperty("refreshtoken")
    private String refreshToken;

    @JsonProperty("iduser")
    private String iduser;

    public AuthResponseDto(String accessToken, String refreshToken, String iduser) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.iduser = iduser;
    }

    @Override
    public String toString() {
        return "AuthResponseDto{" +
                "accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", iduser='" + iduser + '\'' +
                '}';
    }
}
