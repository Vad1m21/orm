package com.povar.orm.service;

import com.povar.orm.entity.Customer;
import com.povar.orm.entity.Project;
import com.povar.orm.repository.CustomerDAO;
import com.povar.orm.repository.ProjectDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProjectService {

    private final ProjectDAO projectDAO;


    public void create(Project project){
       projectDAO.save(project);
    }

    public void update(Project project , Long id){
        projectDAO.update(project,id);
    }

    public List<Project> findAll(){
        return projectDAO.getAll();
    }

    public void delete(Long id){ projectDAO.remove(id); }

    public Project findById(Long id){ return projectDAO.getById(id);}

}
