package com.povar.orm.repository;

import com.povar.orm.entity.Company;
import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public abstract class GenericDAO<T,ID> {
    @Getter
    private  final EntityManager entityManager;

    GenericDAO(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence.xml");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(T t){
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    protected abstract T getById(ID id);

     protected abstract void remove(ID id);

      public abstract List<T> getAll();

      public abstract void update(T t,ID id);
}

