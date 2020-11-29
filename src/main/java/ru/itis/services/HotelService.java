package ru.itis.services;

import ru.itis.models.Hotel;

import java.util.List;

public interface HotelService {
    Hotel vip(String residentId);

    List<Hotel> findAllVips(String name, int stars, boolean big);
}
