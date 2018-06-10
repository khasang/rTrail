package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.Book;

import java.util.List;

public interface BookDao extends BasicDao<Book> {

    /**
     * method for getting book by name
     *
     * @param  name - filter
     * @return list of books by name
     */
    List<Book> getByName(String name);
}
