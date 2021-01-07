package ru.itis.services;

import ru.itis.models.Hotel;
import ru.itis.models.Resident;

import java.util.List;

public interface HotelService {
    Hotel vip(String residentId);

    Resident bookWholeFloor(Resident resident);

    List<Resident> findAllVips(int stars, boolean big);
}
