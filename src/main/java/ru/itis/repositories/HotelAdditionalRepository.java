package ru.itis.repositories;

import ru.itis.models.Hotel;

import java.util.List;

public interface HotelAdditionalRepository {
    List<Hotel> findByNameAndAddress(String name, int stars);
}
