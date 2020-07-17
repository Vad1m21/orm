package com.povar.orm.service;

import com.povar.orm.entity.Company;
import com.povar.orm.entity.Customer;
import com.povar.orm.repository.CustomerDAO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CustomerService {

    private final CustomerDAO customerDAO;


    public void create(Customer customer){
        customerDAO.save(customer);
    }

    public void update(Customer customer , Long id){
        customerDAO.update(customer,id);
    }

    public List<Customer> findAll(){
        return customerDAO.getAll();
    }

    public void delete(Long id){ customerDAO.remove(id); }

    public Customer findById(Long id){ return customerDAO.getById(id);}

}
