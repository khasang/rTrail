package io.khasang.rtrail.service;


import io.khasang.rtrail.entity.Book;

import java.util.List;

public interface BookService {
    /**
     * method for add book
     *
     * @param book - new book for creation
     * @return created book
     */
    Book addBook(Book book);

    /**
     * method for getting book
     *
     * @param id - book's id for getting
     * @return book by id
     */
    Book getBookById(long id);

    /**
     * method for getting all book
     *
     * @return all books
     */
    List<Book> getAllBooks();

    /**
     * method for deleting book
     *
     * @param id - book's id for deleting
     * @return deleted book
     */
    Book deleteBook(long id);

    /**
     * method for getting book by name
     *
     * @param  name - filter
     * @return list of books by name
     */
    List<Book> getBooksByName(String name);


    /**
     * method for updating book
     *
     * @param  book - book for updating
     * @return updated book
     */
    Book updateBook(Book book);

    /**
     * method for patching book
     *
     * @param  book - book for patching
     * @return patched book
     */
    Book patchBook(Book book);
}
