package com.sparta.readinglog.controller;

import com.sparta.readinglog.dto.BookRequestDto;
import com.sparta.readinglog.dto.BookResponseDto;
import com.sparta.readinglog.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BookController {

    private final Map<Long, Book> bookList = new HashMap<>();
    private Long nextId = 1L;

    @PostMapping("/books")
    public BookResponseDto createBook(@RequestBody BookRequestDto requestDto) {
        Book book = new Book(requestDto);

        book.setId(nextId);
        nextId++;

        bookList.put(book.getId(), book);

        return new BookResponseDto(book);
    }

    @GetMapping("/books")
    public List<BookResponseDto> getBooks() {
        return bookList.values().stream()
                .map(BookResponseDto::new)
                .toList();
    }
}