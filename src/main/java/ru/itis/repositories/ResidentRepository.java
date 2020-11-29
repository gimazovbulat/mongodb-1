package ru.itis.repositories;

import ru.itis.models.Resident;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResidentRepository extends MongoRepository<Resident, String> {
}
