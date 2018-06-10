package io.khasang.rtrail.dao.impl;

import io.khasang.rtrail.dao.BookDao;
import io.khasang.rtrail.entity.Book;

import java.util.List;

public class BookDaoImpl extends BasicDaoImpl<Book> implements BookDao {

    public BookDaoImpl(Class<Book> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Book> getBookByName(String bookname) {
        return (List<Book>) getSessionFactory().
                createQuery("from Book as b where b.bookname = ?").setParameter(0, bookname).list();
    }
}
