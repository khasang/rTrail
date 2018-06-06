package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Rout;

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
}
