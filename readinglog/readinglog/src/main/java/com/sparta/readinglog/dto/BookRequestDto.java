package com.sparta.readinglog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookRequestDto {
    private String title;
    private String comment;
}