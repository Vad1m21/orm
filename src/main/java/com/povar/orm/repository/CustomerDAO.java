package com.povar.orm.repository;

import com.povar.orm.entity.Company;
import com.povar.orm.entity.Customer;

import javax.persistence.EntityManager;
import java.util.List;

public class CustomerDAO extends GenericDAO<Customer,Long> {
    @Override
    public Customer getById(Long id) {
        EntityManager entityManager = getEntityManager();
        Customer entityFromDb = entityManager.find(Customer.class, id);
        entityManager.close();

        return entityFromDb;
    }

    @Override
    public void remove(Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Customer entityFromDb =entityManager.find(Customer.class, id);
        entityManager.remove(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Customer> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Customer> entities = entityManager.createQuery("From Customer ").getResultList();
        entityManager.close();
        return entities;
    }
}
