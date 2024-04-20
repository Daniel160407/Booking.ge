package com.booking.service.hotel;

import com.booking.dto.hotel.HotelCollectionDto;
import com.booking.dto.hotel.HotelDto;
import com.booking.model.Hotel;
import com.booking.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class HotelServiceImpl implements HotelService {
    private final Map<String, Hotel> hotels = new HashMap<>();
    private final ModelConverter modelConverter;

    @Autowired
    public HotelServiceImpl(final ModelConverter modelConverter) {
        this.modelConverter = modelConverter;
    }

    @Override
    public HotelDto addHotel(HotelDto hotelDto) {
        Hotel hotel = modelConverter.convert(hotelDto);
        hotels.put(hotel.name(), hotel);
        return hotelDto;
    }

    @Override
    public HotelCollectionDto getHotels() {
        return modelConverter.convertHotels(new ArrayList<>(hotels.values()));
    }
}
