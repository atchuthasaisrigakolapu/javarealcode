package com.example.realjavacode.model;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.Accessors;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Accessors
@Jacksonized
public class RelatedParty {

    String id;
    String name;
    Role role;

}
