package com.jarevalodev.notazas.interfaces.rest;

import com.jarevalodev.notazas.application.commandservices.NoteCommand;
import com.jarevalodev.notazas.application.queryservices.NoteQuery;
import com.jarevalodev.notazas.domain.Note;
import com.jarevalodev.notazas.interfaces.rest.dto.NoteRequest;
import com.jarevalodev.notazas.interfaces.rest.dto.NoteResponse;
import com.jarevalodev.notazas.interfaces.rest.transform.mapper.NoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/notes", produces = "application/json")
public class NoteRestController implements NoteController {

    @Autowired
    NoteQuery noteQuery;

    @Autowired
    NoteCommand noteCommand;

    @Autowired
    NoteMapper noteMapper;

    @GetMapping
    @Override
    public ResponseEntity<List<NoteResponse>> getNotes() {

        final List<Note> notesFromStorage = noteQuery.getNotes();
        final List<NoteResponse> notes = noteMapper.from(notesFromStorage);

        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<NoteResponse> findNoteById(@PathVariable(value = "id") Long id)
        throws Exception {

        try {
            Note noteFromStorage = noteQuery.findById(id);
            NoteResponse noteResponse = noteMapper.from(noteFromStorage);
            return new ResponseEntity<>(noteResponse, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }

    }

    @PostMapping
    @Override
    public ResponseEntity<NoteResponse> create(@RequestBody NoteRequest noteDto) {
        Note draftNote = noteMapper.from(noteDto);

        Note createdNote = noteCommand.addNote(draftNote);
        NoteResponse noteResponse = noteMapper.from(createdNote);

        return new ResponseEntity<NoteResponse>(noteResponse, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    @Override
    public ResponseEntity<NoteResponse> updateById(@RequestBody NoteRequest noteDto, @PathVariable(value = "id") Long id) throws Exception {
        Note draftNote = noteMapper.from(noteDto, id);
        Note updatedNote = noteCommand.updateNote(draftNote, id);
        NoteResponse noteResponse = noteMapper.from(updatedNote);
        return new ResponseEntity<>(noteResponse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        noteCommand.deleteNote(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
