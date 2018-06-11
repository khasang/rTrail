package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.CatDao;
import io.khasang.rtrail.dto.CatDTO;
import io.khasang.rtrail.entity.Cat;
import io.khasang.rtrail.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatServiceImpl implements CatService {

    @Autowired
    private CatDao catDao;

    @Autowired
    private CatDTO catDTO;

    @Override
    public CatDTO addCat(Cat cat) {
        return catDTO.getCatDTO(catDao.create(cat));
    }

    @Override
    public CatDTO getCatById(Long id) {
        return catDTO.getCatDTO(catDao.getById(id));
    }

    @Override
    public List<CatDTO> getAllCats() {
        return catDTO.getList(catDao.getList());
    }

    @Override
    public CatDTO deleteCat(long id) {
        return catDTO.getCatDTO(catDao.delete(catDao.getById(id)));
    }

    @Override
    public List<CatDTO> getCatByName(String name) {
        return catDTO.getList(catDao.getByName(name));
    }

    @Override
    public CatDTO updateCat(Cat cat) {
        return catDTO.getCatDTO(catDao.update(cat));
    }

    @Override
    public CatDTO patchCat(Cat cat) {
        return catDTO.getCatDTO(catDao.update(cat));
    }

}
