package com.booking.service;

import com.booking.dto.RoomCollectionDto;
import com.booking.dto.RoomDto;
import com.booking.model.Room;
import com.booking.util.ModelConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class RoomServiceImpl implements RoomService {
    private final Map<String, Room> rooms = new HashMap<>();
    private final ModelConverter modelConverter;

    @Autowired
    public RoomServiceImpl(ModelConverter modelConverter) {
        this.modelConverter = modelConverter;
    }

    @Override
    public RoomCollectionDto getRooms() {
        return modelConverter.convert(new ArrayList<>(rooms.values()));
    }

    @Override
    public RoomDto addRoom(RoomDto roomDto) {
        Room room = modelConverter.convert(roomDto);
        rooms.put(room.name(), room);
        return roomDto;
    }
}