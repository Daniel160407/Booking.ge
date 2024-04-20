package com.booking.dto.room;

import com.booking.util.RoomState;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoomDto {
    private String name;
    private RoomState roomState;
}
