package io.khasang.rtrail.service;

import io.khasang.rtrail.entity.Location;
import java.util.List;

public interface LocationService {
    /**
     * method for add location
     *
     * @param location - new location for creation
     * @return created location
     */
    Location addLocation(Location location);

    /**
     * method for getting location
     *
     * @param id - location's id for getting
     * @return location by id
     */
    Location getLocationById(long id);

    /**
     * method for getting all locations
     *
     * @return all locations
     */
    List<Location> getAllLocations();

    /**
     * method for getting locations by name
     *
     * @param name = filter
     * @return locations by name
     */
    List<Location> getLocationsByName(String name);

    /**
     * method for deletion location
     *
     * @param id - location's id for delete
     * @return deleted location
     */
    Location deleteLocation(long id);

    /**
     * method for update location
     *
     * @param location for update
     * @return updated location
     */
    Location updateLocation(Location location);
}
