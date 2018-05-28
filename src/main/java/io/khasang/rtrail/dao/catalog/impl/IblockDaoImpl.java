package io.khasang.rtrail.dao.catalog.impl;

import io.khasang.rtrail.dao.catalog.IblockDao;
import io.khasang.rtrail.dao.impl.BasicDaoImpl;
import io.khasang.rtrail.entity.catalog.Iblock;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;

public class IblockDaoImpl extends BasicDaoImpl<Iblock> implements IblockDao {
    public IblockDaoImpl(Class<Iblock> entityClass) {
        super(entityClass);
    }

//    @Override
//    public Iblock getByCode(String code) {
//        return null;
//    }
}

//@Repository
//public class IblockDaoImpl implements IblockDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Transactional
//    public void add(Iblock iblock) {
//        sessionFactory.getCurrentSession().save(iblock);
////        sessionFactory.close();
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public Iblock getIblockByCode(String code) {
//
//        Iblock iblock = null;
//
//        try {
//            @SuppressWarnings("unchecked")
//            TypedQuery<Iblock> query = sessionFactory.getCurrentSession().createQuery("from Iblock where code = :code");
//            query.setParameter("code", code);
//
//            iblock = query.getSingleResult();
//            System.out.println(iblock);
//        }catch (Exception ignored){}
//
//        return iblock;
//    }
//
//}
