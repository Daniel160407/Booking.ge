package com.booking.service.room;

import com.booking.dto.room.RoomCollectionDto;
import com.booking.dto.room.RoomDto;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {
    RoomCollectionDto getRooms(String hotelName);

    RoomDto addRoom(RoomDto roomDto);

    RoomDto updateRoom(RoomDto roomDto);
}
