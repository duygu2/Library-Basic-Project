package com.library.library.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    private String id;

    private String name;
    private String accountId;
    private Integer page;
    private String writer;
    private Category category;

}
