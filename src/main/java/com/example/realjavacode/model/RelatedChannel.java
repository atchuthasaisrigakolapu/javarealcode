package com.example.realjavacode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;

@Value
@Builder
//@Data
//@AllArgsConstructor
@Jacksonized
@Accessors
public class RelatedChannel {

    @NotBlank
    String label;

    String code;
}
