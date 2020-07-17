package com.povar.orm.repository;

import com.povar.orm.entity.Company;
import com.povar.orm.entity.Developer;

import javax.persistence.EntityManager;
import java.util.List;

public class DeveloperDAO  extends  GenericDAO<Developer, Long>{
    @Override
    public Developer getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Developer entityFromDb = entityManager.find(Developer.class, id);
        entityManager.close();

        return entityFromDb;
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Developer entityFromDb =entityManager.find(Developer.class, id);
        entityManager.remove(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Developer> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Developer> entities = entityManager.createQuery("From Developer ").getResultList();
        entityManager.close();
        return entities;
    }
}
