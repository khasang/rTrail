package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Book;

import java.util.List;

public interface BookService {
    Book addBook(Book book);

    Book updateBook(Book book);

    Book getBookById(long id);

    List<Book> getBookByName(String bookname);

    List<Book> getAllBooks();

    Book deleteBook(long id);
}
