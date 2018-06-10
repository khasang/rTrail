package io.khasang.rtrail.service.iml;

import io.khasang.rtrail.dao.BookDao;
import io.khasang.rtrail.entity.Book;
import io.khasang.rtrail.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public Book addBook(Book book) {
        return bookDao.create(book);
    }

    @Override
    public Book getBookById(long id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getList();
    }

    @Override
    public Book deleteBook(long id) {
        Book bookForDelete = getBookById(id);
        return bookDao.delete(bookForDelete);
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return bookDao.getByName(name);
    }

    @Override
    public Book updateBook(Book book) {
        return bookDao.update(book);
    }

    @Override
    public Book patchBook(Book book) {
        return bookDao.update(book);
    }
}
