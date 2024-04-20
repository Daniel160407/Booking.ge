package com.booking.controllers;

import com.booking.dto.room.RoomCollectionDto;
import com.booking.dto.room.RoomDto;
import com.booking.service.room.RoomService;
import com.booking.util.RoomState;
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

    @PostMapping(value = "/state")
    @ResponseBody
    public RoomDto changeRoomState(@RequestParam String roomName, @RequestParam String hotelName, @RequestParam RoomState state) {
        return roomService.updateRoom(new RoomDto(roomName, hotelName, state));
    }
}
