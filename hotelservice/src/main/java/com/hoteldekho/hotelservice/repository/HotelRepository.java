package com.hoteldekho.hotelservice.repository;

import com.hoteldekho.hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {

}
