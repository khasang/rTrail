package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.Cat;
import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {
    /**
     * for getting session factory
     */
    Session getSessionFactory();
    /**
     * method for add entity
     * @param entity - new entity for creation
     * @return created entity
     */
    T create(T entity);

    /**
     * method for getting entity
     * @param id - entity's id for getting
     * @return entity by id
     */
    T getById(long id);


    /**
     * method for getting all entities
     *
     * @return all entities
     */
    List<T> getList();

    /**
     * method for deleting entity
     *
     * @param entityForDelete - entity's id for deleting
     * @return deleted entity
     */
    T delete(T entityForDelete);

    /**
     * method for updating entity
     *
     * @param  entityForUpdate - entity for updating
     * @return updated entity
     */
    T update(T entityForUpdate);
}
