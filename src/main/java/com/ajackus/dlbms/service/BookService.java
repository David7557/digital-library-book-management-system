package com.ajackus.dlbms.service;

import com.ajackus.dlbms.entity.BookEntity;
import com.ajackus.dlbms.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final Map<String, BookEntity> books = new HashMap<>();
    private final Set<BookEntity> bookEntitySet = new HashSet<>();

    public BookEntity addBook(String bookId, String title, String author, String genre) {
        validateInput(title, "Title");
        validateInput(author, "Author");

        if (books.containsKey(bookId)) {
            throw new DuplicateIdFoundException("Book with ID " + bookId + " already exists!");
        }

        BookEntity book = new BookEntity();
        book.setBookId(bookId);
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setAvailabilityStatus("Available");

        books.put(bookId, book);
        return book;
    }

    public ResponseEntity<Set<BookEntity>> viewAllBooks() {
        bookEntitySet.clear();
        bookEntitySet.addAll(books.values());
        return ResponseEntity.ok(bookEntitySet);
    }

    public ResponseEntity<BookEntity> findByBookId(String bookId) {
        BookEntity book = books.get(bookId);
        if (book == null) {
            throw new BookNotFoundByIdException("Book with ID " + bookId + " not found in the database.");
        }
        return ResponseEntity.ok(book);
    }

    public ResponseEntity<BookEntity> findBookByTitle(String title) {
        validateInput(title, "Title");

        for (BookEntity book : books.values()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return ResponseEntity.ok(book);
            }
        }

        throw new BookNotFoundByTitle("Book with title '" + title + "' not found in the database.");
    }


    public ResponseEntity<BookEntity> updateBook(String bookId, String title, String author, String genre, String availabilityStatus) {
        BookEntity book = books.get(bookId);
        if (book == null) {
            throw new BookNotFoundByIdException("Book with ID " + bookId + " does not exist in the database.");
        }

        if (isValid(title)) {
            book.setTitle(title);
        }
        if (isValid(author)) {
            book.setAuthor(author);
        }
        if (isValid(genre)) {
            book.setGenre(genre);
        }
        if (isValid(availabilityStatus)) {
            book.setAvailabilityStatus(availabilityStatus);
        }

        return ResponseEntity.ok(book);
    }

    public ResponseEntity<String> deleteBook(String bookId) {
        if (!books.containsKey(bookId)) {
            throw new BookNotFoundByIdException("Book with ID '" + bookId + "' not found in the catalog.");
        }

        books.remove(bookId);
        return ResponseEntity.ok("Book with ID '" + bookId + "' has been successfully deleted.");
    }

    // Helper method for validation
    private void validateInput(String value, String fieldName) {
        if (!isValid(value)) {
            throw new IllegalArgumentException(fieldName + " should be a non-empty string!");
        }
    }

    // Checks if a string is non-null and non-empty
    private boolean isValid(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
