package com.jarevalodev.notazas.application.commandservices;

import com.jarevalodev.notazas.domain.Note;
import com.jarevalodev.notazas.infrastructure.repository.mongo.configuration.SequenceGeneratorService;
import com.jarevalodev.notazas.infrastructure.repository.mongo.note.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class NoteCommandService implements NoteCommand{

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Override
    public Note addNote(Note note) {
        note.setId(sequenceGeneratorService.generateSequence(Note.SEQUENCE_NAME));
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note draftNote, Long id) {
        Optional<Note> noteToUpdateOpt = noteRepository.findById(id);
        if(noteToUpdateOpt.isPresent()){
            Note noteToUpdate = noteToUpdateOpt.get();
            noteToUpdate.setText(draftNote.getText());
            log.info("Updating note with id {}", id);
            return noteRepository.save(noteToUpdate);
        }

        draftNote.setId(sequenceGeneratorService.generateSequence(Note.SEQUENCE_NAME));
        log.info("Note with id {} does not exists, creating with id {}", id, draftNote.getId());
        return noteRepository.save(draftNote);
    }

    @Override
    public void deleteNote(Long id) {
        Optional<Note> noteOpt = noteRepository.findById(id);
        if(noteOpt.isPresent()){
            noteRepository.delete(noteOpt.get());
        }
    }
}
