package com.booking.service.hotel;

import com.booking.dto.hotel.HotelCollectionDto;
import com.booking.dto.hotel.HotelDto;
import org.springframework.stereotype.Service;

@Service
public interface HotelService {
    HotelDto addHotel(HotelDto hotel);

    HotelCollectionDto getHotels();
}
