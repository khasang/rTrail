package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.RoutDao;
import io.khasang.rtrail.entity.Rout;
import io.khasang.rtrail.service.RoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * concrete realize of RoutService
 */
@Service
public class RoutServiceImpl implements RoutService {

    @Autowired
    private RoutDao routDao;

    @Override
    public Rout addRout(Rout rout) {
        routDao.create(rout);
        return rout;
    }

    @Override
    public Rout getRoutById(String id) {
        Rout result = null;
        try {
            result = routDao.getById(Long.parseLong(id));
        } catch (NumberFormatException e) {
            System.out.println("Error - id is not a number");
        }
        return result;
    }

    @Override
    public Rout deleteRout(String id) {
        Rout result = getRoutById(id);
        routDao.delete(result);
        return result;
    }

    @Override
    public Rout updateRout(Rout rout) {
        return routDao.update(rout);
    }

    @Override
    public List<Rout> getAllRouts() {
        return routDao.getList();
    }

    @Override
    public List<Rout> getRoutByName(String name) {
        return routDao.getByName(name);
    }

    @Override
    public List<Rout> getAllOwnerRout(String owner) {
        return routDao.getByOwner(owner);
    }
}
