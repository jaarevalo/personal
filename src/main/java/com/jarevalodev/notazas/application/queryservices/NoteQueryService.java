package com.jarevalodev.notazas.application.queryservices;

import com.jarevalodev.notazas.domain.Note;
import com.jarevalodev.notazas.infrastructure.repository.mongo.note.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class NoteQueryService implements NoteQuery{

    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<Note> getNotes() {
        log.info("Finding all notes in mongodb");
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Long id) throws Exception {

        Optional<Note> noteFromStorage = noteRepository.findById(id);

        if (noteFromStorage.isPresent()) {
            return noteFromStorage.get();
        }
        throw new Exception("Note not found");
    }

}
