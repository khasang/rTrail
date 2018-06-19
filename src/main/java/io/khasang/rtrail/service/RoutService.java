package io.khasang.rtrail.service;

import io.khasang.rtrail.dto.RoutDTO;
import io.khasang.rtrail.entity.Rout;

import java.util.List;

/**
 * service CRUD for rout
 */
public interface RoutService {

    /**
     * method for adding rout
     *
     * @param routDTO - rout to add
     * @return added rout
     */
    RoutDTO addRout(RoutDTO routDTO);

    /**
     * method for getting rout by id
     *
     * @param id - rout id
     * @return required rout
     */
    RoutDTO getRoutDTOById(String id);

    /**
     * method for deleting rout
     *
     * @param id - rout id for delete
     * @return deleted rout
     */
    RoutDTO deleteRout(String id);

    /**
     * method for updating rout
     *
     * @param routDTO - rout to update
     * @return updated rout
     */
    RoutDTO updateRout(RoutDTO routDTO);

    /**
     * method for getting all routs
     *
     * @return all routs
     */
    List<RoutDTO> getAllRouts();

    /**
     * method finds rout by name
     *
     * @param name - rout's name to find
     * @return list of routs with same name.
     */
    List<RoutDTO> getRoutByName(String name);

    /**
     * method finds all rout by owner
     *
     * @param owner - rout owner
     * @return list of routs
     */
    List<RoutDTO> getAllOwnerRout(String owner);
}
