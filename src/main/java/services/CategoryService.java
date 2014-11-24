package services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import dao.CategoryDao;
import dao.ConsumerDao;
import models.Category;
import models.Consumer;

import java.util.List;

@Singleton
public class CategoryService {
    @Inject
    private CategoryDao categoryDao;
    @Inject
    private ConsumerDao consumerDao;

    public List<Category> getAllRootCategories() {
        return categoryDao.getAllRoot();
    }

    public List<Category> getAll() {
        return categoryDao.getAll();
    }
}
