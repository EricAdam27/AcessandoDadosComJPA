package com.example.accessingdatajpa.repository;

import com.example.accessingdatajpa.model.CustomerModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {

    List<CustomerModel> findByLastName(String lastName);

    CustomerModel findById(long id);
}
