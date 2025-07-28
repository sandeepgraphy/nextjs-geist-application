package com.urban.model.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "companion_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanionProfile {
    @Id
    private String id;

    private String name;
    private Integer age;
    private String location;
    private List<String> languages;
    private String profilePhoto;
    private String about;
    private Double ratings;
    private Boolean available;
}
