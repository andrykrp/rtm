package dao;

import models.Region;

import java.util.List;

public class RegionDao extends AbstractDao {
    public List<Region> getAll() {
        List<Region> regions = getEntityManager().createQuery("FROM Region").getResultList();
        return regions;
    }
}
