package ru.itis.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.Hotel;
import ru.itis.models.Resident;
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
    public Hotel vip(@RequestParam String residentId) {
        return hotelService.vip(residentId);
    }

    @GetMapping("/hotels/vips")
    public List<Resident> findAllVips(
            @RequestParam("big") Boolean big,
            @RequestParam("stars") Integer stars
    ) {
        return hotelService.findAllVips(stars, big);
    }

    @PostMapping("/residents/wholeFloor")
    public Resident bookWholeFloor(@RequestBody Resident resident) {
        return hotelService.bookWholeFloor(resident);
    }
}
