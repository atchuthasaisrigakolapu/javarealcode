package com.example.realjavacode.model;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

@Value
@Builder
@Jacksonized
@Accessors
public class ProductOfferingQulaification {

    String id;
    OffsetDateTime productOfferingQulalificationDate;
    OffsetDateTime expectedActivationDate;
    String realm;
    @Valid List<RelatedChannel> relatedChannel;
    @Valid List<ProductOfferingQualificationItem> productOfferingQualificationItem;
    TaskStateType state;
    Map<String,String> additionalProperties;
}
