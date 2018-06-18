package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.LocationDao;
import io.khasang.rtrail.dto.LocationDTO;
import io.khasang.rtrail.entity.Location;
import io.khasang.rtrail.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private LocationDTO locationDTO;

    @Override
    public LocationDTO addLocation(Location location) {
        return locationDTO.getLocationDTO(locationDao.create(location));
    }

    @Override
    public LocationDTO getLocationById(long id) {
        return locationDTO.getLocationDTO(locationDao.getById(id));
    }

    @Override
    public List<LocationDTO> getAllLocations() {
        return locationDTO.getList(locationDao.getList()) ;
    }

    @Override
    public List<LocationDTO> getLocationsByName(String name) {
        return locationDTO.getList(locationDao.getByName(name));
    }

    @Override
    public LocationDTO deleteLocation(long id) {

        return locationDTO.getLocationDTO(locationDao.delete(locationDao.getById(id)));
    }

    @Override
    public LocationDTO updateLocation(Location location) {
        return locationDTO.getLocationDTO(locationDao.update(location));
    }
}

