package com.booking.util;

import com.booking.dto.hotel.HotelCollectionDto;
import com.booking.dto.hotel.HotelDto;
import com.booking.dto.room.RoomCollectionDto;
import com.booking.dto.room.RoomDto;
import com.booking.model.Hotel;
import com.booking.model.Room;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelConverter {
    public RoomCollectionDto convertRooms(List<Room> rooms) {
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
                .hotelName(room.hotelName())
                .roomState(room.roomState())
                .build();
    }

    public Room convert(RoomDto roomDto) {
        return Room.builder()
                .name(roomDto.getName())
                .hotelName(roomDto.getHotelName())
                .roomState(roomDto.getRoomState())
                .build();
    }

    public HotelCollectionDto convertHotels(List<Hotel> hotels) {
        List<HotelDto> roomDtos = hotels.stream()
                .map(this::convertHotelToDto)
                .toList();

        return HotelCollectionDto.builder()
                .hotels(roomDtos)
                .build();
    }

    private HotelDto convertHotelToDto(Hotel hotel) {
        return HotelDto.builder()
                .name(hotel.name())
                .maxMembers(hotel.maxMembers())
                .currentMembers(hotel.currentMembers())
                .build();
    }

    public Hotel convert(HotelDto hotelDto) {
        return Hotel.builder()
                .name(hotelDto.getName())
                .maxMembers(hotelDto.getMaxMembers())
                .currentMembers(hotelDto.getCurrentMembers())
                .build();
    }
}
