package dao;

import com.google.inject.persist.Transactional;
import models.Consumer;
import models.Offer;

import java.util.List;

public class ConsumerDao extends AbstractDao {

    @Transactional
    public List<Consumer> getAll() {
        List<Consumer> consumers = getEntityManager().createQuery("FROM Consumer").getResultList();
        return consumers;
    }

    @Transactional
    public Consumer getById(Long id) {
        return (Consumer) getEntityManager()
                .createQuery("SELECT c FROM Consumer c WHERE c.id = :consumerId")
                .setParameter("consumerId", id)
                .getSingleResult();
    }

    @Transactional
    public void save(Consumer consumer) {
        getEntityManager().persist(consumer);
    }

    @Transactional
    public Consumer update(Consumer consumer) {
        return getEntityManager().merge(consumer);
    }

    @Transactional
    public void delete(Consumer consumer) {
        getEntityManager().remove(consumer);
    }

    @Transactional
    public void addBookmark(Consumer consumer, Offer offer) {
        consumer.getBookmarks().add(offer);
        update(consumer);
    }
}
