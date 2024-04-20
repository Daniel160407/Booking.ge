package com.booking.model;

import lombok.Builder;

@Builder
public record Hotel(String name, Integer maxMembers, Integer currentMembers) {
}
