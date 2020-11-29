package ru.itis.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.models.Hotel;
import ru.itis.models.Resident;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends MongoRepository<Hotel, String>, HotelAdditionalRepository {
    Optional<Hotel> findByResidents(List<Resident> resident);
}
