package com.jarevalodev.notazas.infrastructure.repository.mongo.note;

import com.jarevalodev.notazas.domain.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

import static java.util.Arrays.asList;

@Repository
public class NoteRepositoryImpl implements NoteCustomRepository {

    @Override
    public List<Note> findSomeNotes() {

        final Note note1  = Note.builder().id(1L).text("This is an awesome note1").createdAt(Instant.now()).build();
        final Note note2  = Note.builder().id(2L).text("This is an awesome note2").createdAt(Instant.now()).build();
        final Note note3  = Note.builder().id(3L).text("This is an awesome note3").createdAt(Instant.now()).build();
        final Note note4  = Note.builder().id(4L).text("This is an awesome note4").createdAt(Instant.now()).build();
        final Note note5  = Note.builder().id(5L).text("This is an awesome note5").createdAt(Instant.now()).build();

        return asList(note1,note2,note3,note4,note5);
    }

}
