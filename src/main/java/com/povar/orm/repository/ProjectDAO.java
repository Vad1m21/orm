package com.povar.orm.repository;

import com.povar.orm.entity.Company;
import com.povar.orm.entity.Developer;
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


    public List<Project> getProjectsFromDB(){
        EntityManager entityManager = getEntityManager();
        List<Project> projects = entityManager.createNativeQuery("select p.date, p.name, count(pd.developer_id) from projects p join developers_projects pd on p.projects_id = pd.project_id group by pd.project_id").getResultList();
        entityManager.close();

        return projects;
    } //  повертає [[Ljava.lang.Object;@1e84f3c8, [Ljava.lang.Object;@5f59ea8c, [Ljava.lang.Object;@7b2ccba5, [Ljava.lang.Object;@64f9f455, [Ljava.lang.Object;@5d5a51b1, [Ljava.lang.Object;@4dc7cd1c]


}
