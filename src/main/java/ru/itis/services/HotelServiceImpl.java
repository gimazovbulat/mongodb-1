package ru.itis.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.Hotel;
import ru.itis.models.Resident;
import ru.itis.repositories.HotelRepository;
import ru.itis.repositories.ResidentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.mongodb.client.model.Projections.*;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService {
    private final ResidentRepository residentRepository;
    private final HotelRepository hotelRepository;
    private final ObjectMapper objectMapper;

    @Transactional
    @Override
    public Hotel vip(String residentId) {
        Resident resident = residentRepository.findById(residentId)
                .orElseThrow(() -> new IllegalStateException("resident doesn't exist"));
        Hotel hotel = hotelRepository.findByResidents(Collections.singletonList(resident))
                .orElseThrow(() -> new IllegalStateException("hotel doesn't exist"));

        hotel.getVips().add(resident.getName());
        return hotel;
    }

    @Override
    public List<Hotel> findAllVips(String name, int stars, boolean big) {
        Document searchQuery = new Document();

        MongoClient client = MongoClients.create();
        MongoDatabase database = client.getDatabase("javalab_hw");
        MongoCollection<Document> collection = database.getCollection("hotels");

        searchQuery
                .append("isBig", true)
                .append("$or", Arrays.asList(
                        new Document("stars", new Document("$gt", stars)),
                        new Document("big", big)));

        FindIterable<Document> resultDocuments = collection.find(searchQuery)
                .projection(fields(include("name", "stars", "isBig"), excludeId()));

        List<Hotel> hotels = new ArrayList<>();
        for (Document doc : resultDocuments){
            try {
                Hotel hotel = objectMapper.readValue(doc.toJson(), Hotel.class);
                hotels.add(hotel);
            } catch (JsonProcessingException e) {
                throw new IllegalStateException(e);
            }
        }
        return hotels;
    }
}
