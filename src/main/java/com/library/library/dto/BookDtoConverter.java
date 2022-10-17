package com.library.library.dto;

import com.library.library.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDtoConverter {
    public BookDto convert(Book book){
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .page(book.getPage())
                .accountId(book.getAccountId())
                .category(book.getCategory())
                .writer(book.getWriter())
                .build();
    }
}
