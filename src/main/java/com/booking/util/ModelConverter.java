package com.booking.util;

import com.booking.dto.RoomCollectionDto;
import com.booking.dto.RoomDto;
import com.booking.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelConverter {
    public RoomCollectionDto convert(List<Room> rooms) {
        List<RoomDto> roomDtos = rooms.stream()
                .map(this::convertRoomToDto)
                .collect(Collectors.toList());

        return RoomCollectionDto.builder()
                .rooms(roomDtos)
                .build();
    }

    private RoomDto convertRoomToDto(Room room) {
        return RoomDto.builder()
                .name(room.name())
                .maxMembers(room.maxMembers())
                .currentMembers(room.currentMembers())
                .build();
    }

    public Room convert(RoomDto roomDto) {
        return Room.builder()
                .name(roomDto.getName())
                .maxMembers(roomDto.getMaxMembers())
                .currentMembers(roomDto.getCurrentMembers())
                .build();
    }
}
