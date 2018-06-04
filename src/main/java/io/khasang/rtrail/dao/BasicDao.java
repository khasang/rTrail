package io.khasang.rtrail.dao;

import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {

    /**
     * for getting session factory
     */
    Session getSessionFactory();

    /**
     * method for add entity
     *
     * @param entity - new entity for creation
     * @return created entity
     */
    T create(T entity);

    /**
     * method for getting entity
     *
     * @param id - entity's id for getting
     * @return entity by id
     */
    T getById(Long id);

    /**
     * method for getting all entities
     *
     * @return all entities
     */
    List<T> getList();

    /**
     * method for delete specify entity
     *
     * @param entity = entity for delete
     * @return entity
     */
    T delete(T entity);

    /**
     * method for updation entity
     *
     * @param entity - entity's entity for update
     * @return updated entity
     */
    T update(T entity);

}
