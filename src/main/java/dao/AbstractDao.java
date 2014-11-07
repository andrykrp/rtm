package dao;

import com.google.inject.Inject;
import com.google.inject.Provider;

import javax.persistence.EntityManager;

public abstract class AbstractDao {
    @Inject
    private Provider<EntityManager> entityManagerProvider;

    public EntityManager getEntityManager() {
        return entityManagerProvider.get();
    }
}
