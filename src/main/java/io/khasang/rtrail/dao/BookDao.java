package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.Book;

import java.util.List;

public interface BookDao extends BasicDao<Book> {
    List<Book> getBookByName(String bookname);
}
