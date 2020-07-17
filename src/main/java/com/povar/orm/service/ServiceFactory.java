package com.povar.orm.service;

import com.povar.orm.repository.*;

public class ServiceFactory {

    public CompanyService getCompanyService(){
        return  new CompanyService(new CompanyDAO());
    }

    public CustomerService getCustomerService(){
        return new CustomerService(new CustomerDAO());
    }

    public DeveloperService getDeveloperService(){
        return new DeveloperService(new DeveloperDAO());
    }

    public ProjectService getProjectService(){
        return new ProjectService(new ProjectDAO());
    }

    public SkillService getSkillService(){
        return new SkillService(new SkillDAO());
    }
}
