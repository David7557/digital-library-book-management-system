package com.ajackus.dlbms.service;

import com.ajackus.dlbms.entity.BookEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BookService {
    private HashMap<String, BookEntity> books = new HashMap<>();

    public BookEntity addBook(String bookId, String title, String author, String genre){
        BookEntity book = new BookEntity();
        book.setBookId(bookId);
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setAvailabilityStatus(true);
        books.put(book.getBookId(), book);
        return book;
    }
}
