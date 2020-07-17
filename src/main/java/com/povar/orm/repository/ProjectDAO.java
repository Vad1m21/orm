package com.povar.orm.repository;

import com.povar.orm.entity.Company;
import com.povar.orm.entity.Project;

import javax.persistence.EntityManager;
import java.util.List;

public class ProjectDAO extends GenericDAO<Project,Long>{
    @Override
    public Project getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Project entityFromDb = entityManager.find(Project.class, id);
        entityManager.close();

        return entityFromDb;
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Project entityFromDb =entityManager.find(Project.class, id);
        entityManager.remove(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Project> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Project> entities = entityManager.createQuery("From Project ").getResultList();
        entityManager.close();
        return entities;
    }
}
