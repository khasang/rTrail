package io.khasang.rtrail.dao;

import io.khasang.rtrail.entity.Location;

import java.util.List;

public interface LocationDao extends BasicDao<Location> {
    /**
     * method for getting locations by name
     *
     * @param name = filter
     * @return locations by name
     */
    List<Location> getByName(String name);
}

