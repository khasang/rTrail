package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.BookDao;
import io.khasang.rtrail.entity.Book;
import io.khasang.rtrail.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public Book addBook(Book book) {
        return bookDao.create(book);
    }

    @Override
    public Book updateBook(Book book) {
        return bookDao.update(book);
    }

    @Override
    public Book getBookById(long id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getBookByName(String bookname) {
        return bookDao.getBookByName(bookname);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getList();
    }

    @Override
    public Book deleteBook(long id) {
        Book bookForDelete = bookDao.getById(id);
        return bookDao.delete(bookForDelete);
    }
}
