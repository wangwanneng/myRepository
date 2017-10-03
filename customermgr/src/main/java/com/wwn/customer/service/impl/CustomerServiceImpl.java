package com.wwn.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wwn.customer.dao.CustomerDao;
import com.wwn.customer.entity.Customer;
import com.wwn.customer.entity.CustomerQuery;
import com.wwn.customer.service.CustomerService;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public int create(Customer customer) {
		return customerDao.create(customer);
	}

	@Override
	public int update(Customer customer) {
		return customerDao.update(customer);
	}

	@Override
	public int delete(int uuid) {
		return customerDao.delete(uuid);
	}

	@Override
	public Customer getByUuId(int uuid) {
		return customerDao.getByUuId(uuid);
	}

	@Override
	public List<Customer> getByConditionPage(CustomerQuery customerQuery) {
		return customerDao.getByConditionPage(customerQuery);
	}

}
