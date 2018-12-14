package com.sti.bootcamp.dao.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sti.bootcamp.model.Account;

public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {
	Account findByAccountnumber(int accountnumber);
}
