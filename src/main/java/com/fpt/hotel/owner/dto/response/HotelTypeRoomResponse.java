package com.fpt.hotel.owner.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HotelTypeRoomResponse {

    private Integer id;

    private Integer totalNumberRoom;

    private String nameHotel;

    private String nameTypeRoom;
}
