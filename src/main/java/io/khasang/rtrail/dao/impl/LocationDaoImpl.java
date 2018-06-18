package io.khasang.rtrail.dao.impl;


import io.khasang.rtrail.dao.LocationDao;

import io.khasang.rtrail.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LocationDaoImpl extends BasicDaoImpl<Location> implements LocationDao {
    public LocationDaoImpl(Class<Location> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Location> getByName(String name) {
        return (List<Location>) getSessionFactory().
                createQuery("from location as l where l.name = ?").setParameter(0, name).list();
    }
}
