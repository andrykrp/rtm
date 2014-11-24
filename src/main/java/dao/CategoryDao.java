package dao;

import com.google.inject.persist.Transactional;
import models.Category;

import java.util.List;

public class CategoryDao extends AbstractDao {

    @Transactional
    public Category getById(Long categoryId) {
        return (Category) getEntityManager().createQuery("SELECT c FROM Category c WHERE c.id = :categoryId")
                .setParameter("categoryId", categoryId)
                .getSingleResult();
    }

    @Transactional
    public List<Category> getAll() {
        return getEntityManager().createQuery("FROM Category").getResultList();
    }

    @Transactional
    public List<Category> getAllRoot() {
        return getEntityManager().createQuery("SELECT c FROM Category c WHERE c.parentCategory IS NULL")
                .getResultList();
    }
}
