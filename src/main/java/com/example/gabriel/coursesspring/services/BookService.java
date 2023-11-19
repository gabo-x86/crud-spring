package com.example.gabriel.coursesspring.services;

import com.example.gabriel.coursesspring.domain.entities.Book;

import java.util.List;

public interface BookService {

    public List<Book> getBooksByStudent(Integer studentId);

    public Book saveBook(Book book);
}
