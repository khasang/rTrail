package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Author;

import java.util.List;

public interface AuthorService {
    /**
     * method for add author
     *
     * @param author - new author for creation
     * @return created author
     */
    Author addAuthor(Author author);

    /**
     * method for getting author
     *
     * @param id - author's id for getting
     * @return author by id
     */
    Author getAuthorById(long id);

    /**
     * method for getting all author
     *
     * @return all authors
     */
    List<Author> getAllAuthors();

    /**
     * method for deleting author
     *
     * @param id - author's id for deleting
     * @return deleted author
     */
    Author deleteAuthor(long id);

    /**
     * method for getting author by firs name
     *
     * @param firstName - filter
     * @return list of author by first name
     */
    List<Author> getAuthorsByFirstName(String firstName);

    /**
     * method for getting author by firs name
     *
     * @param lastName - filter
     * @return list of author by first name
     */
    List<Author> getAuthorsByLastName(String lastName);


    /**
     * method for updating author
     *
     * @param author - author for updating
     * @return updated author
     */
    Author updateAuthor(Author author);

    /**
     * method for patching author
     *
     * @param author - author for patching
     * @return patched author
     */
    Author patchAuthor(Author author);
}