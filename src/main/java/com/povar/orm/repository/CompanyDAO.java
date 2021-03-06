package com.povar.orm.repository;

import com.povar.orm.entity.Company;
import com.povar.orm.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class CompanyDAO extends GenericDAO<Company,Long> {


    @Override
    public Company getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Company entityFromDb = entityManager.find(Company.class, id);
        entityManager.close();

        return entityFromDb;
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Company entityFromDb =entityManager.find(Company.class, id);
        entityManager.remove(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Company> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Company> entities = entityManager.createQuery("From Company ").getResultList();
        entityManager.close();
        return entities;
    }


}


