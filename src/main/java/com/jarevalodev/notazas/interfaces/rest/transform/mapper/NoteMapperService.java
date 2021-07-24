package com.jarevalodev.notazas.interfaces.rest.transform.mapper;

import com.jarevalodev.notazas.domain.Note;
import com.jarevalodev.notazas.interfaces.rest.dto.NoteRequest;
import com.jarevalodev.notazas.interfaces.rest.dto.NoteResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class NoteMapperService implements NoteMapper {

    @Override
    public List<NoteResponse> from(List<Note> notesFromStorage) {

        List<NoteResponse> notesDto = notesFromStorage.stream().map(note -> {
            return NoteResponse.builder()
                .id(note.getId())
                .text(note.getText())
                .build();
        }).collect(Collectors.toList());

        return notesDto;
    }

    @Override
    public NoteResponse from(Note noteFromStorage) {
        return NoteResponse.builder()
            .id(noteFromStorage.getId())
            .text(noteFromStorage.getText())
            .build();
    }

    @Override
    public
    Note from(NoteRequest noteDto) {
        return Note.builder().text(noteDto.getText()).build();
    }

    @Override
    public Note from(NoteRequest noteDto, Long id) {
        return Note.builder().id(id).text(noteDto.getText()).build();
    }
}
