package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.Author;

import java.util.List;

public interface AuthorDao extends BasicDao<Author> {
    List<Author> getAuthorByName(String authorname);
}
