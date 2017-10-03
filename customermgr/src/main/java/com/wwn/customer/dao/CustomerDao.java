package com.wwn.customer.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.wwn.customer.entity.Customer;
import com.wwn.customer.entity.CustomerQuery;

@Repository
public interface CustomerDao {

	public int create(Customer customer);
	public int update(Customer customer);
	public int delete(int uuid);
	
	public Customer getByUuId(int uuid);
	//分页查询
	public List<Customer> getByConditionPage(CustomerQuery condition);
}
