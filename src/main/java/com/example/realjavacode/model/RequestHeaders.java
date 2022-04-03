package com.example.realjavacode.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Accessors
@Jacksonized
public class RequestHeaders {
    String franchise;
    String applicationId;
    String requestId;
    String operatorId;
}
