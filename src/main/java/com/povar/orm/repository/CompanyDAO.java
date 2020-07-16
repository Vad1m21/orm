package com.povar.orm.repository;

import com.povar.orm.entity.Company;
import com.povar.orm.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CompanyDAO extends GenericDAO<Company,Long> {

    

    @Override
    protected Company getById(Long id) {
        return null;
    }

    @Override
    protected void remove(Long id) {

    }

    @Override
    public List<Company> getAll() {
        EntityManager entityManager = getEntityManager();
        List<Company> companies = entityManager.createQuery("From companies").getResultList();
        entityManager.close();
        return companies;
    }

    @Override
    public void update(Company company, Long id) {
        EntityManager entityManager = getEntityManager();
        entityManager.getTransaction().begin();
        Company entityFromDb = entityManager.find(Company.class, id);
        entityManager.merge(company);
        entityManager.persist(entityFromDb);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}


