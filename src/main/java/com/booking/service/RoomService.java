package com.booking.service;

import com.booking.dto.RoomCollectionDto;
import com.booking.dto.RoomDto;
import com.booking.model.Room;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {
    RoomCollectionDto getRooms();

    RoomDto addRoom(RoomDto roomDto);
}
