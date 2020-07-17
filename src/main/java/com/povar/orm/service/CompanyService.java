package com.povar.orm.service;

import com.povar.orm.entity.Company;
import com.povar.orm.repository.CompanyDAO;
import com.sun.xml.bind.v2.model.core.ID;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.agent.builder.AgentBuilder;

import java.util.List;

@RequiredArgsConstructor
public class CompanyService {

    private final CompanyDAO companyDAO;



    public void create(Company company){
        companyDAO.save(company);
    }

    public void update(Company company , Long id){
        companyDAO.update(company,id);
    }

    public List<Company> findAll(){
        return companyDAO.getAll();
    }

    public void delete(Long id){ companyDAO.remove(id); }

    public Company findById(Long id){ return companyDAO.getById(id);}
}
