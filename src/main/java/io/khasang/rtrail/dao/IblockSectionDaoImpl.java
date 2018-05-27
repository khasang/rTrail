package io.khasang.rtrail.dao;

import io.khasang.rtrail.dao.interfaces.IblockSectionDao;
import io.khasang.rtrail.entity.Iblock;
import io.khasang.rtrail.entity.IblockSection;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class IblockSectionDaoImpl implements IblockSectionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void add(IblockSection iblockSection) {
        sessionFactory.getCurrentSession().save(iblockSection);
    }

    @Transactional(readOnly = true)
    @Override
    public List<IblockSection> listSections(Iblock iblock) {
        @SuppressWarnings("unchecked")
        TypedQuery<IblockSection> query = sessionFactory.getCurrentSession().createQuery("from IblockSection where iblock = :iblock");
        query.setParameter("iblock", iblock);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    @Override
    public IblockSection getSectionByCode(String code, Iblock iblock) {

        IblockSection iblockSection = null;

        try {
            @SuppressWarnings("unchecked")
            TypedQuery<IblockSection> query = sessionFactory.getCurrentSession().createQuery("from IblockSection where iblock = :iblock AND code = :code");
            query.setParameter("iblock", iblock);
            query.setParameter("code", code);

            iblockSection = query.getSingleResult();
            System.out.println(iblockSection);
        } catch (Exception ignored) {
        }

        return iblockSection;
    }

}
