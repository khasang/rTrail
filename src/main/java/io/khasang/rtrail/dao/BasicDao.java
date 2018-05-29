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
     * method for getting entity
     *
     * @param code - entity's code for getting
     * @return entity by code
     */
    T getByCode(String code);

    /**
     * method for getting all entities
     *
     * @return all entities
     */
    List<T> getList();

    /**
     * method for deletion entityForDelete
     *
     * @param entityForDelete - entity's entityForDelete for delete
     * @return deleted entity
     */
    T delete(T entityForDelete);

    /**
     * method for updation entity
     *
     * @param entityForUpdate - entity's entityForUpdate for update
     * @return updated entity
     */
    T update(T entityForUpdate);

}
