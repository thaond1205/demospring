package com.fpt.hotel.repository;

import com.fpt.hotel.model.HotelTypeRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelTypeRoomRepository extends JpaRepository<HotelTypeRoom , Integer> {
}
