package com.jarevalodev.notazas.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notes")
public class Note {

    @Transient
    public static final String SEQUENCE_NAME = "notes_sequence";

    @Id
    private Long id;

    private Instant createdAt;
    private String text;

}
