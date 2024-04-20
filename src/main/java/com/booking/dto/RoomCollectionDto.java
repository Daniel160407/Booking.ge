package com.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RoomCollectionDto {
    private List<RoomDto> rooms;
}
