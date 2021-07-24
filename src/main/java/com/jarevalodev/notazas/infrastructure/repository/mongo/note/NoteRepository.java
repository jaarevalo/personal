package com.jarevalodev.notazas.infrastructure.repository.mongo.note;

import com.jarevalodev.notazas.domain.Note;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface NoteRepository extends MongoRepository<Note, Long>, NoteCustomRepository {

    List<Note> findAll();

    Optional<Note> findById(Long id);
}
