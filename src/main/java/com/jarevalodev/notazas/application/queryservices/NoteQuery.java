package com.jarevalodev.notazas.application.queryservices;

import com.jarevalodev.notazas.domain.Note;

import java.util.List;

public interface NoteQuery {

    List<Note> getNotes();

    Note findById(Long id) throws Exception;

}
