package com.booking.model;

import lombok.Builder;

@Builder
public record Room(String name, Integer maxMembers, Integer currentMembers) {
}
