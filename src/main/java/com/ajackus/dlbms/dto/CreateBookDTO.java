package com.ajackus.dlbms.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookDTO {
    private String bookId;
    private String title;
    private String author;
    private String genre;
}
