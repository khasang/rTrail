package io.khasang.rtrail.dao.catalog.impl;

import io.khasang.rtrail.dao.catalog.IblockSectionDao;
import io.khasang.rtrail.dao.impl.BasicDaoImpl;
import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockSection;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IblockSectionDaoImpl extends BasicDaoImpl<IblockSection> implements IblockSectionDao {
     public IblockSectionDaoImpl(Class<IblockSection> entityClass) {
            super(entityClass);
        }

//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Transactional
//    public void add(IblockSection iblockSection) {
//        sessionFactory.getCurrentSession().save(iblockSection);
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public List<IblockSection> listSections(Iblock iblock) {
//        @SuppressWarnings("unchecked")
//        TypedQuery<IblockSection> query = sessionFactory.getCurrentSession().createQuery("from IblockSection where iblock = :iblock");
//        query.setParameter("iblock", iblock);
//        return query.getResultList();
//    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public IblockSection getSectionByCode(String code, Iblock iblock) {
//
//        IblockSection iblockSection = null;
//
//        try {
//            @SuppressWarnings("unchecked")
//            TypedQuery<IblockSection> query = sessionFactory.getCurrentSession().createQuery("from IblockSection where iblock = :iblock AND code = :code");
//            query.setParameter("iblock", iblock);
//            query.setParameter("code", code);
//
//            iblockSection = query.getSingleResult();
//            System.out.println(iblockSection);
//        } catch (Exception ignored) {
//        }
//
//        return iblockSection;
//    }
//
//    @Override
//    public Map<String, String> getList(Iblock iblock) {
//
//        List<IblockSection> iblockSections = listSections(iblock); // todo other solution
//
//        Map<String, String> sections = new HashMap<>();
//        for (IblockSection iblockSection : iblockSections) {
//            sections.put("/" + iblock.getCode() + "/" + iblockSection.getCode(), iblockSection.getName());
//        }
//
//        return sections;
//    }

}
