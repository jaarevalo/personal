package com.jarevalodev.notazas.interfaces.rest.transform.mapper;

import com.jarevalodev.notazas.domain.Note;
import com.jarevalodev.notazas.interfaces.rest.dto.NoteRequest;
import com.jarevalodev.notazas.interfaces.rest.dto.NoteResponse;
import org.springframework.stereotype.Component;

import java.util.List;

public interface NoteMapper {

    List<NoteResponse> from(List<Note> notesFromStorage);

    NoteResponse from(Note noteFromStorage);

    Note from(NoteRequest noteDto);

    Note from(NoteRequest noteDto, Long id);
}
