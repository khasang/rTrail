package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.Rout;

import java.util.List;

/**
 * interface for rout's data manipulation
 */
public interface RoutDao extends BasicDao<Rout> {

    /**
     * method finds all routs with name
     *
     * @param name - name of rout to find
     * @return list of routs
     */
    List<Rout> getByName(String name);

    /**
     * method find all routs belongs to owner
     *
     * @param owner - routs owner
     * @return list of routs belongs to owner
     */
    List<Rout> getByOwner(String owner);
}
