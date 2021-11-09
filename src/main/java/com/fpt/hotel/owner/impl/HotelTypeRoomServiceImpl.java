package com.fpt.hotel.owner.impl;

import com.fpt.hotel.model.Hotel;
import com.fpt.hotel.model.HotelTypeRoom;
import com.fpt.hotel.model.Type_room;
import com.fpt.hotel.owner.dto.request.HotelTypeRoomRequest;
import com.fpt.hotel.owner.dto.response.HotelTypeRoomResponse;
import com.fpt.hotel.owner.service.IHotelTypeRoomService;
import com.fpt.hotel.repository.HotelRepository;
import com.fpt.hotel.repository.HotelTypeRoomRepository;
import com.fpt.hotel.repository.TypeRoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelTypeRoomServiceImpl implements IHotelTypeRoomService {

    @Autowired
    HotelTypeRoomRepository hotelTypeRoomRepository;

    @Autowired
    HotelRepository hotelRepository;

    @Autowired
    TypeRoomRepository typeRoomRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public HotelTypeRoomResponse save(HotelTypeRoomRequest hotelTypeRoomRequest) {
        Long idTypeRoom = hotelTypeRoomRequest.getIdTypeRoom();
        Long idHotel = hotelTypeRoomRequest.getIdHotel();
        Optional<Hotel> hotelOptional = hotelRepository.findById(idHotel);
        Optional<Type_room> typeRoomOptional  = typeRoomRepository.findById(idTypeRoom);
        if(hotelOptional.isEmpty() && typeRoomOptional.isEmpty()){
            return null;
        }

        HotelTypeRoom hotelTypeRoom = new HotelTypeRoom();
        hotelTypeRoom.setTotalNumberRoom(hotelTypeRoomRequest.getTotalNumberRoom());
        hotelTypeRoom.setTypeRoom(typeRoomOptional.get());
        hotelTypeRoom.setHotel(hotelOptional.get());
        hotelTypeRoomRepository.save(hotelTypeRoom);
        return modelMapper.map(hotelTypeRoom , HotelTypeRoomResponse.class);
    }

    @Override
    public List<HotelTypeRoomResponse> findAll() {
        return hotelTypeRoomRepository.findAll().stream().map(
                hotelTypeRoom -> modelMapper.map(hotelTypeRoom , HotelTypeRoomResponse.class)).collect(Collectors.toList());
    }
}
