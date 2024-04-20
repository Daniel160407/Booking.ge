package com.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class RoomDto {
    private String name;
    private Integer maxMembers;
    private Integer currentMembers;
}
