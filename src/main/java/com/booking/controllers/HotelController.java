package com.booking.controllers;

import com.booking.dto.hotel.HotelCollectionDto;
import com.booking.dto.hotel.HotelDto;
import com.booking.service.exception.MembersLimitReachedException;
import com.booking.service.hotel.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Booking/hotels")
@CrossOrigin(origins = "*")
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

    @PutMapping
    public ResponseEntity<HotelCollectionDto> updateHotel(@RequestParam String name) {
        try {
            HotelCollectionDto updatedHotels = hotelService.updateHotel(name);
            return ResponseEntity.ok(updatedHotels);
        } catch (MembersLimitReachedException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.OPTIONS).build();
    }
}
