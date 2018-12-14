package com.sti.bootcamp.dao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sti.bootcamp.model.Customer;
//JPA Repository adalah induk dari PaginAndSortingaRepository = interface
//Integer = tipe dari primary key
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {
//	Customer findByCustomerNumber(int customerNumber)
}
