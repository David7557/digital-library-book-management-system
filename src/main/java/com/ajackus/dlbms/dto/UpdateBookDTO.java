package com.ajackus.dlbms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBookDTO {
    private String title;
    private String author;
    private String genre;
    private String availabilityStatus;
}
