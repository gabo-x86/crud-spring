package com.example.gabriel.coursesspring.web.rest;

import com.example.gabriel.coursesspring.domain.entities.Book;
import com.example.gabriel.coursesspring.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/students/{studentId}/books")
public class StudentBookController {
    private final BookService bookService;

    public StudentBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> listBooks(@PathVariable final Integer studentId){
        return ResponseEntity.ok().body(this.bookService.getBooksByStudent(studentId));
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody final Book book) throws URISyntaxException {
        if(book.getId() != null){
            throw new IllegalArgumentException("A new book cannot has an id");
        }

        book.setCreatedAt(LocalDateTime.now());
        Book bookDB = this.bookService.saveBook(book);
        /**
         * Esta URI ya puede ser accedida con GET
         * */
        return ResponseEntity
                .created(new URI("/v1/students/" + bookDB.getStudent().getId() + "/books/" + bookDB.getId()))
                .body(bookDB);
    }
}
