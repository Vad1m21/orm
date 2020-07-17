package com.povar.orm.repository;

import com.povar.orm.entity.Company;
import com.povar.orm.entity.Skill;

import javax.persistence.EntityManager;
import java.util.List;

public class SkillDAO extends GenericDAO<Skill,Long>{
    @Override
    public Skill getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Skill entityFromDb = entityManager.find(Skill.class, id);
        entityManager.close();

        return entityFromDb;
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Skill entityFromDb =entityManager.find(Skill.class, id);
        entityManager.remove(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Skill> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Skill> entities = entityManager.createQuery("From Skill ").getResultList();
        entityManager.close();
        return entities;
    }
}
