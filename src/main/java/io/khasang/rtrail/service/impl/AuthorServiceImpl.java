package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.AuthorDao;
import io.khasang.rtrail.entity.Author;
import io.khasang.rtrail.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorDao authorDao;

    @Override
    public Author addAuthor(Author author) {
        return authorDao.create(author);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorDao.update(author);
    }

    @Override
    public Author getAuthorById(long id) {
        return authorDao.getById(id);
    }

    @Override
    public List<Author> getAuthorByName(String authorname) {
        return authorDao.getAuthorByName(authorname);
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorDao.getList();
    }

    @Override
    public Author deleteAuthor(long id) {
        Author authorForDelete = authorDao.getById(id);
        return authorDao.delete(authorForDelete);
    }
}
