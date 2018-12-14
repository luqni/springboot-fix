package com.bootcamp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sti.bootcamp.dao.AccountDao;
import com.sti.bootcamp.model.Account;
import com.sti.bootcamp.model.Customer;



@RestController
@RequestMapping("/Account") // menentukan path url
public class ControllerAccount {
	@Autowired
	private AccountDao accountDao;
	@GetMapping("/account")
	public String viewaccount (@RequestParam(value="id", defaultValue="") String id) {
		try {
			Account acc = accountDao.getById(Integer.valueOf(id));
			if(acc == null) {
				return "data tidak ditmukan";
			}else {
				return "hello"+ acc.getOpendate();
//				customer.getFirtsname();
			}
		}catch(NumberFormatException e) {
			return "salah format input";
		}catch(Exception e) {
			return String.format("terjadi kesalahan : %s", e.getMessage());
		}
		
	}
	@PostMapping("/post")
	public Account postAccount(@RequestBody Account account) throws Exception {
		Account data = accountDao.save(account);
		return data;
		
	}
	@DeleteMapping("/account/{id}")
	public void account(@PathVariable ("id") Account data) throws Exception{
		accountDao.delete(data);
	}
	
	@GetMapping("/accounts")
	public List<Account> getlist() throws Exception{
		List<Account> list = accountDao.getList();
		return list;
	}

}
