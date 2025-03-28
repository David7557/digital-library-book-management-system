package com.ajackus.dlbms.service;

import com.ajackus.dlbms.entity.BookEntity;
import com.ajackus.dlbms.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.*;

@Service
public class BookService {
    private final HashMap<String, BookEntity> books = new HashMap<>();
    private final HashSet<BookEntity> bookEntitySet = new HashSet<>();
    private String requestBookId = null;
    public BookEntity addBook(String bookId, String title, String author, String genre) {
        if (title == null || title.isEmpty()) {
            throw new InvalidTitleException("Title should be non-empty strings!");
        } else {
            if (author == null || author.isEmpty()) {
                throw new InvalidAuthorException("Author should be non-empty strings!");
            } else {
                BookEntity book = new BookEntity();
                book.setBookId(bookId);
                book.setTitle(title);
                book.setAuthor(author);
                book.setGenre(genre);
                book.setAvailabilityStatus(true);
                if (!books.containsKey(bookId)) {
                    books.put(bookId, book);
                } else {
                    throw new DuplicateIdFoundException("Book already exist!");
                }
                return book;
            }
        }

    }

    public ResponseEntity<HashSet<BookEntity>> viewAllBooks() {
        Set<String> keys = books.keySet();
        for (String key : keys) {
            bookEntitySet.add(books.get(key));
        }
        return ResponseEntity.ok(bookEntitySet);
    }

    public ResponseEntity<BookEntity> findBybookId(String bookId) {
        var book = books.get(bookId);

        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            throw new BookNotFoundByIdException("Book you're trying find with bookId: " + bookId + " is not exist in db");
        }
    }

    public ResponseEntity<BookEntity> findBookByTitle(String title){
        for (BookEntity book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return ResponseEntity.ok(book);
            }
        }

        throw new BookNotFoundByTitle("Book you're trying find with title: "+ title + " is not exist in db");
    }

}
