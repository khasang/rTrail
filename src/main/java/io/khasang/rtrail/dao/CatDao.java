package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.Cat;

import java.util.List;

public interface CatDao extends BasicDao<Cat>{

    /**
     * method for getting cat by name
     *
     * @param  name - filter
     * @return list of cats by name
     */
    List getByName(String name);
}
