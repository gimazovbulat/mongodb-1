package ru.itis.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import ru.itis.models.Hotel;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Repository
@RequiredArgsConstructor
public class HotelAdditionalRepositoryImpl implements HotelAdditionalRepository {
    private final MongoTemplate mongoTemplate;

    @Override
    public List<Hotel> findByNameAndAddress(String name, int stars) {
        return mongoTemplate.find(new Query(
                where("name").is(name)
                        .andOperator(where("stars").is(stars))), Hotel.class);
    }
}
