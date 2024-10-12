package org.example.springprepare.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemoRequestDto {

    private String username;
    private String contents;
}
