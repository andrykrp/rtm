package dao;

import models.Producer;

import java.util.List;

public class ProducerDao extends AbstractDao {

    public List<Producer> getAll() {
        List<Producer> producers = getEntityManager().createQuery("FROM Producer").getResultList();
        return producers;
    }
}
