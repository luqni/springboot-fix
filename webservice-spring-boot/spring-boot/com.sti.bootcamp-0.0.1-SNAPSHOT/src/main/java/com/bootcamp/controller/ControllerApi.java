package com.bootcamp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ExcludeDefaultListeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sti.bootcamp.dao.CustomerDao;
import com.sti.bootcamp.model.Customer;

@RestController
@RequestMapping("/Customer")
public class ControllerApi {
	
	
	@Autowired
	private CustomerDao customerDao;
	
//	List<Customer> data = new ArrayList<>();
	
	//get customer
	@GetMapping("/customer")
	public String viewCustomer(@RequestParam(value="id", defaultValue="") String id) {
		try {
			Customer customer = customerDao.getById(Integer.valueOf(id));
			if(customer == null) {
				return "data tidak ditmukan";
			}else {
				return "hello"+ customer.getFirtsname();
//				customer.getFirtsname();
			}
		}catch(NumberFormatException e) {
			return "salah format input";
		}catch(Exception e) {
			return String.format("terjadi kesalahan : %s", e.getMessage());
		}
	}
	
	@PostMapping("/post")
	public Customer postCustomer(@RequestBody Customer customer) throws Exception{
		Customer data = customerDao.save(customer);
		return data;
	}
	
	@DeleteMapping("/customer/{id}")
	public void customer(@PathVariable ("id") Customer data) throws Exception{
		customerDao.delete(data);
	}
	
	@PutMapping("/customer")
	public Customer update(@RequestBody Customer customer) throws Exception {
		Customer update = customerDao.save(customer);
		return update;
	}
	
	@GetMapping("/customers")
	public List<Customer> getlist() throws Exception{
		List<Customer> list = customerDao.getList();
		return list;
	}
	
	
	
//	ArrayList<Customer> list = new ArrayList<>();
	
//	@GetMapping("/customerss")
//	public List<Customer> getList(){
//		Customer tra = new Customer();
//		tra.setFirtsname("TRA");
//		List<Customer> list = new ArrayList<>();
//		list.add(tra);
//		return list;
//	}
//	
//	
//	
//	//get 
//	@GetMapping("/customer/{id}")
//	public Customer getById(@PathVariable ("id") String id) {
//		Customer cus = new Customer();
//		cus.setId(Integer.parseInt(id));
//		cus.setFirtsname("Tri Rahmat Aribowo");
//		cus.setLastname("boowo");
//		return cus;
//	}
//	
//	//post
//	@PostMapping("/customer")
//	public Customer Create(@RequestBody Customer customer) {
//		return customer;
//	}
//	
//	@PutMapping("/customerss")
//	public Customer Update(@RequestBody Customer customer) {
//		customer.setId(100);
//		return customer;
//	}
//	
//	@GetMapping("/customers")
//	public List<Customer> getlist(){
//		List<Customer> list = new ArrayList<>();
//		return list;
//	}
//	
//	
//	@DeleteMapping("/customer/{id}")
//	public Customer DeletById(@PathVariable String id) {
//		Customer tra = new Customer();
//		tra.setId(Integer.parseInt(id));
//		return tra;
//	}
//	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/customer/{id}")
//	public String GetBulk(@PathVariable("id") String id) {
//		return "hallo"+id;
//	}
	
//	@GetMapping("/customer")
//	public String ajjaj(@RequestParam ("id") String id) {
//		return "mantap"+ id;
//	}
	
//	 
//	//post
//	@PostMapping("/customer")
//	public String Create(@RequestBody Customer customer) {
//		return "Hallo "+customer.getFirtsname();
//	}
//	
//	//delete
//	@DeleteMapping("/customer/{id}")
//	public String DeleteById(@PathVariable("id") String id) {
//		return "Delete by id : " + id;
//	}
//	
//	//udate 
//	@PutMapping("/customer")
//	public String Update(@RequestBody Customer customer) {
//		return "Anda Telah Update data : "+customer.getFirtsname();
//	}
	
	//getlist
//	@GetMapping("/customers")
//	public Getlist(@RequestBody) {
//		List<Customer> list = new ArrayList<>();
//		return list;
//	}
//	
	
//	@GetMapping(value="/hello")
//	public String index() {
//		return "hello";
//	}
//	
//	@GetMapping("/dewa")
//	public String index2() {
//		return "dewa";
//	}
//	
//	@GetMapping("/haha")
//	public String yahu() {
//		return "hello word";
//	}
}
