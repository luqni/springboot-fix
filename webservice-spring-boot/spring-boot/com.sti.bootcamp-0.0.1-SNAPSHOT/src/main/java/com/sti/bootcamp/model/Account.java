package com.sti.bootcamp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	@Column
	private int accountnumber;
	@Column
	private Date opendate;
	@Column
	private int balance;
	@ManyToOne
	@JoinColumn(name="customerid")
	private Customer customerid; //dalam pojo hibernate field yang berelasi type datanya model entity nya
	
	
	public Account() { }


	public int getId() {
		return accountnumber;
	}


	public void setId(int accountnumber) {
		this.accountnumber = accountnumber;
	}


	public Date getOpendate() {
		return opendate;
	}


	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}


	public int getBalance() {
		return balance;
	}


	public void setBalance(int balance) {
		this.balance = balance;
	}


	public Customer getCustomerid() {
		return customerid;
	}


	public void setCustomerid(Customer customerid) {
		this.customerid = customerid;
	}
	
}
