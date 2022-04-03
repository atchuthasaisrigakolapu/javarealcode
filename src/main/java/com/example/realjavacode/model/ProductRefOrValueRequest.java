package com.example.realjavacode.model;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Value
@Builder
@Accessors
@Jacksonized
public class ProductRefOrValueRequest {

    @NotBlank
    String id;
    @NotBlank
    String productType;
    String type;
    @Valid
    @NotEmpty
    List<RelatedParty> relatedparty;
}
