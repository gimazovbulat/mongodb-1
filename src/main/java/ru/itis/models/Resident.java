package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "resident")
public class Resident {
    @Id
    private String _id;
    private String name;
    private String age;
    private boolean isLoggedIn;
    private boolean isVip;
}
