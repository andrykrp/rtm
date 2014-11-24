package dao;

import com.google.inject.persist.Transactional;
import models.Advice;

import java.util.List;

public class AdviceDao extends AbstractDao {

    @Transactional
    public void save(Advice advice) {
        getEntityManager().persist(advice);
    }

    @Transactional
    public List<Advice> getAll() {
        return getEntityManager().createQuery("FROM Advice").getResultList();
    }
}
