package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Rout;

import java.util.List;

/**
 * service CRUD for rout
 */
public interface RoutService {

    /**
     * method for adding rout
     *
     * @param rout - rout to add
     * @return added rout
     */
    Rout addRout(Rout rout);

    /**
     * method for getting rout by id
     *
     * @param id - rout id
     * @return required rout
     */
    Rout getRoutById(String id);

    /**
     * method for deleting rout
     *
     * @param id - rout id for delete
     * @return deleted rout
     */
    Rout deleteRout(String id);

    /**
     * method for updating rout
     *
     * @param rout - rout to update
     * @return updated rout
     */
    Rout updateRout(Rout rout);

    /**
     * method for getting all routs
     *
     * @return all routs
     */
    List<Rout> getAllRouts();

    /**
     * method finds rout by name
     *
     * @param name - rout's name to find
     * @return list of routs with same name.
     */
    List<Rout> getRoutByName(String name);

    /**
     * method finds all rout by owner
     *
     * @param owner - rout owner
     * @return list of routs
     */
    List<Rout> getAllOwnerRout(String owner);
}
