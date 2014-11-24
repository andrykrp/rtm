package services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dao.CategoryDao;
import dao.ConsumerDao;
import dao.OfferDao;
import models.Category;
import models.Consumer;
import models.Offer;

@Singleton
public class ConsumerService {
    @Inject
    private OfferDao offerDao;
    @Inject
    private CategoryDao categoryDao;
    @Inject
    private ConsumerDao consumerDao;

    public void addCategory(Long consumerId, Long categoryId) {
        Category category = categoryDao.getById(categoryId);
        Consumer consumer = consumerDao.getById(consumerId);
        consumer.getCategories().add(category);

        consumerDao.update(consumer);
    }

    public void removeCategory(Long consumerId, Long categoryId) {
        Category category = categoryDao.getById(categoryId);
        Consumer consumer = consumerDao.getById(consumerId);
        if (consumer.getCategories().contains(category)) {
            consumer.getCategories().remove(category);
        }

        consumerDao.update(consumer);
    }

    public void addBookmark(Long consumerId, Long offerId) {
        Offer offer = offerDao.getById(offerId);
        Consumer consumer = consumerDao.getById(consumerId);
        consumer.getBookmarks().add(offer);

        consumerDao.update(consumer);
    }

    public void removeBookmark(Long consumerId, Long offerId) {
        Offer offer = offerDao.getById(offerId);
        Consumer consumer = consumerDao.getById(consumerId);
        if (consumer.getBookmarks().contains(offer)) {
            consumer.getBookmarks().remove(offer);
        }

        consumerDao.update(consumer);
    }
}
