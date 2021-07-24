package com.jarevalodev.notazas.interfaces.rest;

import com.jarevalodev.notazas.domain.Note;
import com.jarevalodev.notazas.interfaces.rest.dto.NoteRequest;
import com.jarevalodev.notazas.interfaces.rest.dto.NoteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface NoteController {

    ResponseEntity<List<NoteResponse>> getNotes();

    ResponseEntity<NoteResponse> findNoteById(Long id) throws Exception;

    ResponseEntity<NoteResponse> create(NoteRequest noteDto);

    ResponseEntity<NoteResponse> updateById(@RequestBody NoteRequest noteDto, Long id) throws Exception;

    ResponseEntity<Void> delete(@PathVariable Long id);

}
