package com.jarevalodev.notazas.interfaces.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoteRequest {

    @Valid
    private String text;

}
