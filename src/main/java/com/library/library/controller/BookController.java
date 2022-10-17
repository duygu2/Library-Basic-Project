package com.library.library.controller;

import com.library.library.dto.BookDto;
import com.library.library.dto.CreateBookRequest;
import com.library.library.dto.UpdateAccountRequest;
import com.library.library.dto.UpdateBookRequest;
import com.library.library.service.BookService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable String id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }
    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody CreateBookRequest createBookRequest){
        return ResponseEntity.ok(bookService.createBook(createBookRequest));
    }
    @PutMapping("/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable String id,
                                              @RequestBody UpdateBookRequest bookRequest){
        return ResponseEntity.ok(bookService.updateBook(id,bookRequest));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable String id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

}
