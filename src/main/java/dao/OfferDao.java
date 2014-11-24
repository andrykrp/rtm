package dao;

import com.google.inject.persist.Transactional;
import models.Offer;

import java.util.List;

public class OfferDao extends AbstractDao {

    @Transactional
    public List<Offer> getAll() {
        List<Offer> offers = getEntityManager().createQuery("FROM Offer").getResultList();
        return offers;
    }

    @Transactional
    public Offer getById(Long id) {
        return (Offer) getEntityManager()
                .createQuery("SELECT o FROM Offer o WHERE o.id = :offerId")
                .setParameter("offerId", id)
                .getSingleResult();
    }

    @Transactional
    public boolean save(Offer offer) {
        getEntityManager().persist(offer);
        return offer.getId() != null;
    }

    @Transactional
    public Offer update(Offer offer) {
        return getEntityManager().merge(offer);
    }

    @Transactional
    public void delete(Offer offer) {
        getEntityManager().remove(offer);
    }

}
