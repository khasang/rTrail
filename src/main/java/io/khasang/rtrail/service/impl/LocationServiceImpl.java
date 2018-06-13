package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.LocationDao;
import io.khasang.rtrail.entity.Location;
import io.khasang.rtrail.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDao locationDao;

    @Override
    public Location addLocation(Location location) {
        return locationDao.create(location);
    }

    @Override
    public Location getLocationById(long id) {
        return locationDao.getById(id);
    }

    @Override
    public List<Location> getAllLocations() {
        return locationDao.getList();
    }

    @Override
    public List<Location> getLocationsByName(String name) {
        return locationDao.getByName(name);
    }

    @Override
    public Location deleteLocation(long id) {
        Location locationForDelete = getLocationById(id);
        return locationDao.delete(locationForDelete);
    }

    @Override
    public Location updateLocation(Location location) {
        return locationDao.update(location);
    }
}

