package com.booking.service.room;

import com.booking.dto.room.RoomCollectionDto;
import com.booking.dto.room.RoomDto;
import com.booking.model.Room;
import com.booking.util.ModelConverter;
import com.booking.util.RoomState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final List<Room> rooms = new ArrayList<>();
    private final ModelConverter modelConverter;

    @Autowired
    public RoomServiceImpl(ModelConverter modelConverter) {
        this.modelConverter = modelConverter;
    }

    @Override
    public RoomCollectionDto getRooms(String hotelName) {
        List<Room> rooms = new ArrayList<>();
        for (Room room : this.rooms) {
            if (room.getHotelName().equals(hotelName) && room.getRoomState() == RoomState.FREE) {
                rooms.add(room);
            }
        }
        return modelConverter.convertRooms(rooms);
    }

    @Override
    public RoomDto addRoom(RoomDto roomDto) {
        Room room = modelConverter.convert(roomDto);
        rooms.add(room);
        return roomDto;
    }

    @Override
    public RoomDto updateRoom(RoomDto roomDto) {
        rooms.removeIf(room -> room.getHotelName().equals(roomDto.getHotelName()) && room.getName().equals(roomDto.getName()));
        Room room = modelConverter.convert(roomDto);
        rooms.add(room);
        return roomDto;
    }
}
