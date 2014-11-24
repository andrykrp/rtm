package dao;

import com.google.inject.persist.Transactional;
import models.Region;

import java.util.List;

public class RegionDao extends AbstractDao {

    @Transactional
    public List<Region> getAll() {
        List<Region> regions = getEntityManager().createQuery("FROM Region").getResultList();
        return regions;
    }
}
