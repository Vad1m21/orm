package com.povar.orm.service;

import com.povar.orm.entity.Customer;
import com.povar.orm.entity.Developer;
import com.povar.orm.repository.CustomerDAO;
import com.povar.orm.repository.DeveloperDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DeveloperService {

    private final DeveloperDAO developerDAO;


    public void create(Developer developer){
        developerDAO.save(developer);
    }

    public void update(Developer developer , Long id){
        developerDAO.update(developer,id);
    }

    public List<Developer> findAll(){
        return developerDAO.getAll();
    }

    public void delete(Long id){ developerDAO.remove(id); }

    public Developer findById(Long id){ return developerDAO.getById(id);}

}
