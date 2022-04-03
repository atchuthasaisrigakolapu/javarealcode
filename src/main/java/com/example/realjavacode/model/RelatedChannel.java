package com.example.realjavacode.model;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;

@Value
@Builder
@Jacksonized
@Accessors
public class RelatedChannel {

    @NotBlank
    String label;

    String code;
}
