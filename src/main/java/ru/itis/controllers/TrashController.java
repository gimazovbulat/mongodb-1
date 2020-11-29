package ru.itis.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.models.Hotel;
import ru.itis.repositories.HotelRepository;
import ru.itis.services.HotelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TrashController {
    private final HotelRepository hotelRepository;
    private final HotelService hotelService;

    @GetMapping("/hotels-trash")
    public List<Hotel> getByNameAndAddress(@RequestParam("name") String name,
                                           @RequestParam("stars") int stars) {
        return hotelRepository.findByNameAndAddress(name, stars);
    }

    @PostMapping("/hotels/vip")
    public List<String> vip(String residentId) {
        Hotel hotel = hotelService.vip(residentId);
        return hotel.getVips();
    }
}
