package com.sti.bootcamp.dao;

import java.util.List;

import com.sti.bootcamp.model.Account;



public interface AccountDao {
	Account getById(int id) throws Exception;
	Account save(Account account) throws Exception;
	void delete(Account account) throws Exception;
	
	List<Account> getList() throws Exception;
}
