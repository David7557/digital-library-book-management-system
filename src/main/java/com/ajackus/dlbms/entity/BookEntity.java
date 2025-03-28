package com.ajackus.dlbms.entity;

import lombok.Data;

@Data
public class BookEntity {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;
}
