package com.booking.dto.hotel;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HotelCollectionDto {
    private List<HotelDto> hotels;
}
