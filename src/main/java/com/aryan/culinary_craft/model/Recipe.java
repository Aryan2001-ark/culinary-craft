package com.aryan.culinary_craft.model;

import com.aryan.culinary_craft.util.IdGenerator;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@Document(collection = "recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recipe {

    @Id
    @Builder.Default
    private String id= IdGenerator.generateUUID();

    private String name;

    private String description;

    private List<String> ingredients;

    private List<String> steps;

    private String cuisine;

    private int prepTimeInMinutes;

    private int cookTimeInMinutes;

    private String totalServing;

    private String createdBy;

    @CreatedDate
    @Field("created_at")
    private Instant createdAt;

    @LastModifiedDate
    @Field("updated_at")
    private Instant updatedAt;
}

