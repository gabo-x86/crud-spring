package com.example.gabriel.coursesspring.services.implement;

import com.example.gabriel.coursesspring.domain.entities.Book;
import com.example.gabriel.coursesspring.repositories.BookRespository;
import com.example.gabriel.coursesspring.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    private final BookRespository bookRespository;

    public BookServiceImpl(BookRespository bookRespository) {
        this.bookRespository = bookRespository;
    }


    @Override
    public List<Book> getBooksByStudent(Integer studentId) {
        return this.bookRespository.findAll().stream()
                .filter(book -> Objects.equals(book.getStudent().getId(), studentId)).collect(Collectors.toList());
    }

    @Override
    public Book saveBook(Book book) {
        return this.bookRespository.save(book);
    }
}
