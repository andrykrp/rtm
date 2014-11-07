package dao;

import models.Category;

import java.util.List;

public class CategoryDao extends AbstractDao {
    public List<Category> getAll() {
        return getEntityManager().createQuery("FROM Category").getResultList();
    }
}
