package dao;

import com.google.inject.persist.Transactional;
import models.Wish;

public class WishDao extends AbstractDao {

    @Transactional
    public void save(Wish wish) {
        getEntityManager().persist(wish);
    }
}
