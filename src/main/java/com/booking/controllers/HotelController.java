package com.booking.controllers;

import com.booking.dto.hotel.HotelCollectionDto;
import com.booking.dto.hotel.HotelDto;
import com.booking.service.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Booking/hotels")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @ResponseBody
    @GetMapping
    public HotelCollectionDto getHotels() {
        return hotelService.getHotels();
    }

    @ResponseBody
    @PostMapping
    public HotelDto addHotel(@RequestBody HotelDto hotelDto) {
        return hotelService.addHotel(hotelDto);
    }
}
