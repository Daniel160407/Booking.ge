package com.booking.dto.room;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoomCollectionDto {
    private List<RoomDto> rooms;
}
