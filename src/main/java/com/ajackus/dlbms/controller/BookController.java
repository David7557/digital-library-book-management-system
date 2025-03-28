package com.ajackus.dlbms.controller;

import com.ajackus.dlbms.dto.CreateBookDTO;
import com.ajackus.dlbms.entity.BookEntity;
import com.ajackus.dlbms.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.HashSet;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookEntity> addBook(@RequestBody CreateBookDTO body) {
        var book = bookService.addBook(body.getBookId(), body.getTitle(), body.getAuthor(), body.getGenre());
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<HashSet<BookEntity>> viewAllBooks() {
        var books = bookService.viewAllBooks();
        return ResponseEntity.ok(books).getBody();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookEntity> findBookById(@PathVariable String bookId){
        var book = bookService.findBybookId(bookId);
        return ResponseEntity.ok(book).getBody();
    }

    @GetMapping("/{title}")
    public ResponseEntity<BookEntity> findBookByTitle(@PathVariable String title){
        var book = bookService.findBookByTitle(title);
        return ResponseEntity.ok(book).getBody();
    }

}
