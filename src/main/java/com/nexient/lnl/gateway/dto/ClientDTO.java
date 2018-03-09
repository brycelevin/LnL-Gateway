package com.nexient.lnl.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientDTO {
    @JsonProperty("ClientId")
    Integer clientId;

    @JsonProperty("ClientName")
    String clientName;

    @JsonProperty("GLCode")
    String glCode;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getGlCode() {
        return glCode;
    }

    public void setGlCode(String glCode) {
        this.glCode = glCode;
    }
}
