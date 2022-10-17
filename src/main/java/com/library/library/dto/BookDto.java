package com.library.library.dto;

import com.library.library.model.Category;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private String id;
    private String name;
    private String accountId;
    private Integer page;
    private String writer;
    private Category category;
}
