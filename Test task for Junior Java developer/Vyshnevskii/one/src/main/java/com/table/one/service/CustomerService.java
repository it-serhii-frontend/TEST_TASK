package com.table.one.service;

import com.table.one.mod.Customer;
import com.table.one.rep.CustomerReposetory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerReposetory postRepo;
    
    public Customer findById(Long id) {
        return postRepo.findById(id).orElse(null);
    }

    public Iterable<Customer> findAll() {
        return postRepo.findAll();
    }


    public Customer savePost(Customer post) {
        return postRepo.save(post);
    }


    public void deleteById(Long id) {
        
                postRepo.deleteById(id);
          
    }
    

   
}
