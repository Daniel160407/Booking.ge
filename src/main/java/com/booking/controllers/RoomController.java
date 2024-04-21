package com.booking.controllers;

import com.booking.dto.room.RoomCollectionDto;
import com.booking.dto.room.RoomDto;
import com.booking.service.room.RoomService;
import com.booking.util.RoomState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Booking/rooms")
@CrossOrigin(origins = "*")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    @ResponseBody
    public RoomCollectionDto getRooms(@RequestParam String hotelName) {
        return roomService.getRooms(hotelName);
    }

    @PostMapping
    @ResponseBody
    public RoomDto addRoom(@RequestBody RoomDto roomDto) {
        return roomService.addRoom(roomDto);
    }

    @PutMapping (value = "/state")
    @ResponseBody
    public RoomDto changeRoomState(@RequestBody RoomDto roomDto) {
        return roomService.updateRoom(roomDto);
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok().allow(HttpMethod.GET, HttpMethod.POST, HttpMethod.PUT, HttpMethod.OPTIONS).build();
    }
}
