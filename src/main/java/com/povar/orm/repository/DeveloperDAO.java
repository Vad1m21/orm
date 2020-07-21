package com.povar.orm.repository;

import com.povar.orm.entity.Company;
import com.povar.orm.entity.Developer;
import com.povar.orm.entity.Project;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
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

    public List<BigDecimal> getSumSalaryOfDevelopers(Long id){
        EntityManager entityManager = getEntityManager();
        List<BigDecimal> sum = entityManager.createNativeQuery(String.format("select sum(salary) from developers_projects pd inner join projects p on pd.project_id = p.project_id inner join developers d on pd.developer_id = d.developers_id where p.project_id = %d",id)).getResultList();
        entityManager.close();

        return sum;
    }

    public List<Developer>  getAllDevelopersFromProject(Long id){
        EntityManager entityManager = getEntityManager();
        List<Developer> developers = entityManager.createNativeQuery("SELECT * FROM developers_projects as dp JOIN developers as d on dp.developer_id = d.developers_id WHERE project_id = "+ id, Developer.class).getResultList();
        entityManager.close();
        return developers;
    } // не працює Encountered a duplicated sql alias [name] during auto-discovery of a native-sql query

    public List<Developer> getDevelopersBySkill(String name){
        EntityManager entityManager = getEntityManager();
        List<Developer> developers = entityManager.createNativeQuery(String.format(" SELECT * FROM my_db.developers_skills ds inner join developers d on ds.developer_id = d.developers_id inner join skills s on ds.skill_id = s.Skills_id where s.name = '%s'",name)).getResultList();
        entityManager.close();

        return developers;
    } // Encountered a duplicated sql alias [name] during auto-discovery of a native-sql query

    public List<Developer> getDevelopersBySkillOfLanguage(String level){
        EntityManager entityManager = getEntityManager();
        List<Developer> developers = entityManager.createNativeQuery(String.format("SELECT * FROM my_db.developers_skills ds inner join developers d on ds.developer_id = d.developers_id inner join skills s on ds.skill_id = s.Skills_id  where s.level = '%s' group by d.developers_id", level)).getResultList();
        entityManager.close();

        return developers;
    }  // NonUniqueDiscoveredSqlAliasException: Encountered a duplicated sql alias [name] during auto-discovery of a native-sql query
}


