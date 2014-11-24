package dao;

import com.google.inject.persist.Transactional;
import models.Producer;

import java.util.List;

public class ProducerDao extends AbstractDao {

    @Transactional
    public List<Producer> getAll() {
        List<Producer> producers = getEntityManager().createQuery("FROM Producer").getResultList();
        return producers;
    }
}
