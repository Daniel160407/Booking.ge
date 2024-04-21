package com.booking.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Hotel {
    private String name;
    private Integer maxMembers;
    private Integer currentMembers;
}
