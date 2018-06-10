package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Author;

import java.util.List;

public interface AuthorService {
    Author addAuthor(Author author);

    Author updateAuthor(Author author);

    Author getAuthorById(long id);

    List<Author> getAuthorByName(String authorname);

    List<Author> getAllAuthor();

    Author deleteAuthor(long id);
}
