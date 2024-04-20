package com.booking.dto.room;

import com.booking.util.RoomState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RoomDto {
    private String name;
    private String hotelName;
    private RoomState roomState;
}
