package io.khasang.rtrail.dao.catalog.impl;

import io.khasang.rtrail.dao.catalog.IblockElementDao;
import io.khasang.rtrail.entity.catalog.Iblock;
import io.khasang.rtrail.entity.catalog.IblockElement;
import io.khasang.rtrail.entity.catalog.IblockSection;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class IblockElementDaoImpl implements IblockElementDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void add(IblockElement iblockElement) {
        sessionFactory.getCurrentSession().save(iblockElement);
    }

    @Transactional(readOnly = true)
    @Override
    public List<IblockElement> listElements(Iblock iblock, IblockSection iblockSection) {
        @SuppressWarnings("unchecked")
        TypedQuery<IblockElement> query = sessionFactory.getCurrentSession().createQuery("from IblockElement where iblock = :iblock AND iblock_section = :iblock_section");
        query.setParameter("iblock", iblock);
        query.setParameter("iblock_section", iblockSection);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public IblockElement getElementByCode(String code, Iblock iblock, IblockSection iblockSection) {

        IblockElement iblockElement = null;

        try {
            @SuppressWarnings("unchecked")
            TypedQuery<IblockElement> query = sessionFactory.getCurrentSession().createQuery("from IblockElement where iblock = :iblock AND iblock_section = :iblock_section AND code = :code");
            query.setParameter("iblock", iblock);
            query.setParameter("iblock_section", iblockSection);
            query.setParameter("code", code);

            iblockElement = query.getSingleResult();
            System.out.println(iblockElement);
        } catch (Exception ignored) {
        }

        return iblockElement;
    }

}
