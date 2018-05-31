package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.Cat;
import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {
    /**
     * method for add entity
     *
     * @param entity - new entity for creation
     * @return created entity
     **/
    T create(T entity);

    /**
     * method for getting entity
     *
     * @param id - entity's for getting
     * @return entity by id
     */
    T getById(long id);

    /**
     *for getting session factory
     */
    Session getSessionFactory();


    /**
     *for getting all cats
     * @return all cats
     */
    List<T> getList();

    /**
     * method for deletion entity
     *
     * @param entityForDelete - entityForDelete for delete
     * @return deleted entityForDelete
     */
    T delete(T entityForDelete);

    /**
     * method for updating entity
     *
     * @param entityForUpdate - entity for update
     * @return updated entity
     */
    T update(T entityForUpdate);
}
