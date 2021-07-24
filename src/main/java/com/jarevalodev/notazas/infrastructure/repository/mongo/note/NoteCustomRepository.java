package com.jarevalodev.notazas.infrastructure.repository.mongo.note;

import com.jarevalodev.notazas.domain.Note;

import java.util.List;

public interface NoteCustomRepository {
    List<Note> findSomeNotes();
}
