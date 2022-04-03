package com.example.realjavacode.model;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.List;

@Value
@Builder
@Accessors
@Jacksonized
public class ProductOfferingQualficationItemRequest {

    ProductActionType action;

    OffsetDateTime effectiveDate;
    OffsetDateTime expirtionDate;

    @Valid
    @NotNull
    ProductRefOrValueRequest product;

    @Valid List<ProductOfferingQualficationItemRequest> productOfferingQualificationItem;
}
