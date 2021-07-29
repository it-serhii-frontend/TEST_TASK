package com.table.one.rep;

import com.table.one.mod.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReposetory extends CrudRepository<Customer, Long>
{



}
