package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.Author;

import java.util.List;

public interface AuthorDao extends BasicDao<Author>{

    /**
     * method for getting author by first name
     *
     * @param  firstName - filter
     * @return list of authors by first name
     */
    List<Author> getByFirstName(String firstName);

    /**
     * method for getting author by last name
     *
     * @param  lastName - filter
     * @return list of authors by last name
     */
    List<Author> getByLastName(String lastName);
}
