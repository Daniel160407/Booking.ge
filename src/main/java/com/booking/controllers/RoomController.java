package com.booking.controllers;

import com.booking.dto.RoomCollectionDto;
import com.booking.dto.RoomDto;
import com.booking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Booking/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    @ResponseBody
    public RoomCollectionDto getRooms() {
        return roomService.getRooms();
    }

    @PostMapping
    @ResponseBody
    public RoomDto addRoom(@RequestBody RoomDto roomDto) {
        return roomService.addRoom(roomDto);
    }
}
