package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.Cat;

import java.util.List;

public interface CatDao extends BasicDao<Cat> {

    /**
     * method for getting cats by name
     *
     * @param name - filter
     * @return cats by name
     */
    List<Cat> getByName(String name);
}
