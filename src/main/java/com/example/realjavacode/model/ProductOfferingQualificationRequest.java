package com.example.realjavacode.model;

import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;


@Value
@Data
@Accessors
@Jacksonized
public class ProductOfferingQualificationRequest {


    @NotNull OffsetDateTime offsetDateTime;

    @NotBlank String realm;

    @Valid
    @NotEmpty
    List<RelatedChannel> channel;

    @Valid
    @NotEmpty
    List<ProductOfferingQualficationItemRequest>  productOfferingQualficationItemRequests;


}
