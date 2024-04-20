package com.booking.dto.hotel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HotelDto {
    private String name;
    private Integer maxMembers;
    private Integer currentMembers;
}
