package com.wwn.customer.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wwn.customer.entity.Customer;
import com.wwn.customer.entity.CustomerQuery;

public interface CustomerService {

	public int create(Customer customer);
	public int update(Customer customer);
	public int delete(int uuid);
	
	public Customer getByUuId(int uuid);
	//分页查询
	public List<Customer> getByConditionPage(CustomerQuery condition);
}
