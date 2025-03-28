package com.ajackus.dlbms.controller;

import com.ajackus.dlbms.dto.CreateBookDTO;
import com.ajackus.dlbms.dto.UpdateBookDTO;
import com.ajackus.dlbms.entity.BookEntity;
import com.ajackus.dlbms.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookEntity> addBook(@RequestBody CreateBookDTO body) {
        BookEntity book = bookService.addBook(body.getBookId(), body.getTitle(), body.getAuthor(), body.getGenre());
        return ResponseEntity.ok(book);
    }

    @GetMapping
    public ResponseEntity<Set<BookEntity>> viewAllBooks() {
        return bookService.viewAllBooks();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookEntity> findBookById(@PathVariable String bookId) {
        return bookService.findByBookId(bookId);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<BookEntity> findBookByTitle(@PathVariable String title) {
        return bookService.findBookByTitle(title);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<BookEntity> updateBook(@PathVariable String bookId, @RequestBody UpdateBookDTO body) {
        BookEntity book = bookService.updateBook(bookId, body.getTitle(), body.getAuthor(), body.getGenre(), body.getAvailabilityStatus()).getBody();
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId) {
        return bookService.deleteBook(bookId);
    }

}
