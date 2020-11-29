package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "hotel")
public class Hotel {
    @Id
    private String _id;
    private String name;
    private int stars;
    @Field("big")
    private boolean isBig;
    @DBRef
    private List<Resident> residents;
    @DBRef
    private List<String> vips;
}
