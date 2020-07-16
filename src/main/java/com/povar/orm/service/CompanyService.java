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

    public void createCompany(Company company){
        companyDAO.save(company);
    }

    public void updateCompany(Company company , Long id){
        companyDAO.update(company,id);
    }

    public List<Company> findAll(){
        return companyDAO.getAll();
    }
}
