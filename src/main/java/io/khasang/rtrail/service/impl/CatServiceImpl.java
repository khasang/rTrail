package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.CatDao;
import io.khasang.rtrail.entity.Cat;
import io.khasang.rtrail.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {
    @Autowired
    private CatDao catDao;

    @Override
    public Cat addCat(Cat cat) {
        return catDao.create(cat);
    }

    @Override
    public Cat getCatById(Long id) {
        return catDao.getById(id);
    }

    @Override
    public List<Cat> getAllCats() {
        return catDao.getList();
    }

    @Override
    public Cat deleteCat(Long id) {
        Cat catForDelete = getCatById(id);
        return catDao.delete(catForDelete);
    }

    @Override
    public List<Cat> getCatByName(String name) {
        return catDao.getCatByName(name);
    }

    @Override
    public Cat updateCat(Cat cat) {
        return catDao.update(cat);
    }

    @Override
    public Cat patchCat(Cat cat) {
        return catDao.update(cat);
    }
}
