package com.library.library.dto;

import com.library.library.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseBookRequest {

    private String name;
    private String accountId;
    private Integer page;
    private String writer;
    private Category category;
}
