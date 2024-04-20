package com.booking.model;

import com.booking.util.RoomState;
import lombok.Builder;

@Builder
public record Room(String name, RoomState roomState) {
}
