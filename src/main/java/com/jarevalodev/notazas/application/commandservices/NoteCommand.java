package com.jarevalodev.notazas.application.commandservices;

import com.jarevalodev.notazas.domain.Note;

public interface NoteCommand {
    Note addNote(Note note);

    Note updateNote(Note draftNote, Long id);

    void deleteNote(Long id);
}
