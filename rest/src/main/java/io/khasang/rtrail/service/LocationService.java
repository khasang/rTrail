package io.khasang.rtrail.service;

import io.khasang.rtrail.dto.LocationDTO;
import io.khasang.rtrail.entity.Location;
import java.util.List;

public interface LocationService {
    /**
     * method for add location
     *
     * @param location - new location for creation
     * @return created location
     */
    LocationDTO addLocation(Location location);

    /**
     * method for getting location
     *
     * @param id - location's id for getting
     * @return location by id
     */
    LocationDTO getLocationById(long id);

    /**
     * method for getting all locations
     *
     * @return all locations
     */
    List<LocationDTO> getAllLocations();

    /**
     * method for getting locations by name
     *
     * @param name = filter
     * @return locations by name
     */
    List<LocationDTO> getLocationsByName(String name);

    /**
     * method for deletion location
     *
     * @param id - location's id for delete
     * @return deleted location
     */
    LocationDTO deleteLocation(long id);

    /**
     * method for update location
     *
     * @param location for update
     * @return updated location
     */
    LocationDTO updateLocation(Location location);
}
