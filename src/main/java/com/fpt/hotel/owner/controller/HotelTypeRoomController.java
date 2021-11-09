package com.fpt.hotel.owner.controller;

import com.fpt.hotel.owner.dto.request.HotelRequest;
import com.fpt.hotel.owner.dto.request.HotelTypeRoomRequest;
import com.fpt.hotel.owner.dto.response.HotelResponse;
import com.fpt.hotel.owner.dto.response.HotelTypeRoomResponse;
import com.fpt.hotel.owner.service.IHotelTypeRoomService;
import com.fpt.hotel.payload.response.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner/hotel-type-room")
@CrossOrigin("*")
public class HotelTypeRoomController {

    @Autowired
    IHotelTypeRoomService iHotelTypeRoomService;

    @PostMapping("")
    public ResponseEntity<ResponseObject> updateHotel(@RequestBody HotelTypeRoomRequest hotelTypeRoomRequest) {

        HotelTypeRoomResponse hotelTypeRoomResponse =  iHotelTypeRoomService.save(hotelTypeRoomRequest);
        if (hotelTypeRoomResponse != null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(HttpStatus.OK.toString(), "Cập nhật số phòng thành công!", hotelTypeRoomResponse)
            );
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(HttpStatus.NOT_FOUND.toString(), "Cập nhật số phòng thất bại!", hotelTypeRoomResponse)
        );
    }

    @GetMapping("")
    public ResponseEntity<ResponseObject> findAll() {

        List<HotelTypeRoomResponse> hotelTypeRoomResponses =  iHotelTypeRoomService.findAll();
        if (!hotelTypeRoomResponses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject(HttpStatus.OK.toString(), "Trả về danh sách số phòng thành công!", hotelTypeRoomResponses)
            );
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject(HttpStatus.NOT_FOUND.toString(), "Trả về danh sách số phòng thất bại!", hotelTypeRoomResponses)
        );
    }
}
