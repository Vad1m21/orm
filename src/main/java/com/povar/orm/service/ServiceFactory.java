package com.povar.orm.service;

import com.povar.orm.repository.CompanyDAO;

public class ServiceFactory {

    public CompanyService getCompanyService(){
        return  new CompanyService(new CompanyDAO());
    }
}
