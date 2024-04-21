package com.booking.model;

import com.booking.util.RoomState;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Room {
    private String name;
    private String hotelName;
    private RoomState roomState;
}
