package com.hoteldekho.hotelservice.service.Impl;

import com.hoteldekho.hotelservice.entities.Hotel;
import com.hoteldekho.hotelservice.exception.NoResourceFoundException;
import com.hoteldekho.hotelservice.repository.HotelRepository;
import com.hoteldekho.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String uuId = UUID.randomUUID().toString();
        hotel.setId(uuId);
        return  hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new NoResourceFoundException("No Hotel found for id "+ hotelId));
    }

    @Override
    public List<Hotel> getHotels() {

        return hotelRepository.findAll();
    }
}
