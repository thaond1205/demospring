package com.fpt.hotel.owner.service;

import com.fpt.hotel.owner.dto.request.HotelTypeRoomRequest;
import com.fpt.hotel.owner.dto.response.HotelTypeRoomResponse;

import java.util.List;

public interface IHotelTypeRoomService {

    HotelTypeRoomResponse save(HotelTypeRoomRequest hotelTypeRoomRequest);

    List<HotelTypeRoomResponse> findAll();
}
