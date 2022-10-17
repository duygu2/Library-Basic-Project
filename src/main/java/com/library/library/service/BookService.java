package com.library.library.service;

import com.library.library.dto.*;
import com.library.library.model.Book;
import com.library.library.model.Category;
import com.library.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final BookDtoConverter bookDtoConverter;

    public BookService(BookRepository bookRepository, BookDtoConverter bookDtoConverter) {
        this.bookRepository = bookRepository;
        this.bookDtoConverter = bookDtoConverter;
    }

    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtoList=new ArrayList<>();
        for(Book book: books){
            bookDtoList.add(bookDtoConverter.convert(book));

        }
        return bookDtoList;
    }

    public BookDto getBookById(String id) {
        Optional<Book> bookOptional=bookRepository.findById(id);
        return bookOptional.map(bookDtoConverter::convert).orElse(new BookDto());
    }

    public BookDto createBook(CreateBookRequest createBookRequest) {
        Book book=new Book();
        book.setId(createBookRequest.getId());
        book.setName(createBookRequest.getName());
        book.setAccountId(createBookRequest.getAccountId());
        book.setCategory(Category.valueOf(createBookRequest.getCategory().name()));
        book.setWriter(createBookRequest.getWriter());
        book.setPage(createBookRequest.getPage());

        bookRepository.save(book);
        return bookDtoConverter.convert(book);
    }

    public BookDto updateBook(String id, UpdateBookRequest bookRequest) {
        Optional<Book> bookOptional=bookRepository.findById(id);
        bookOptional.ifPresent(book -> {
            book.setName(bookRequest.getName());
            book.setWriter(bookRequest.getWriter());
            book.setCategory(bookRequest.getCategory());
            book.setPage(bookRequest.getPage());
            book.setAccountId(bookRequest.getAccountId());
            bookRepository.save(book);
        });
        return bookOptional.map(bookDtoConverter::convert).orElse(new BookDto());
    }

    public void deleteBook(String id) {
    bookRepository.deleteById(id);
    }
}
