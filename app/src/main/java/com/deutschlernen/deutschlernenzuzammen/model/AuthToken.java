package com.deutschlernen.deutschlernenzuzammen.model;

import java.math.BigInteger;

public class AuthToken {

    private String accessToken;
    private String refreshToken;
    private String tokenType;
    private Integer expiryTime;
    private BigInteger expiration;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Integer expiryTime) {
        this.expiryTime = expiryTime;
    }

    public BigInteger getExpiration() {
        return expiration;
    }

    public void setExpiration(BigInteger expiration) {
        this.expiration = expiration;
    }


}
