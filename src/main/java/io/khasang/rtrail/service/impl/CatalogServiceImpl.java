package io.khasang.rtrail.service.impl;

import io.khasang.rtrail.dao.catalog.IblockDao;
import io.khasang.rtrail.dao.catalog.IblockSectionDao;
import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private IblockDao iblockDao;

    @Autowired
    private IblockSectionDao iblockSectionDao;

    @Override
    public Iblock addIblock(Iblock iblock) {
        return iblockDao.create(iblock);
    }

    @Override
    public Iblock getIblockByCode(String code) {
        return iblockDao.getByCode(code);
    }

    @Override
    public Map<String, String> getIblockSections(Iblock iblock) {

        return null;
//        return iblockSectionDao.getList(iblock);
    }
}
