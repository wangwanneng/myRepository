package com.wwn.customer;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.wwn.customer.dao.CustomerDao;
import com.wwn.customer.entity.Customer;
import com.wwn.customer.entity.CustomerQuery;


@Service
public class Client {

	@Autowired
	private CustomerDao customerDao;
	
	public static void main(String[] args) {
		
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		Client client = (Client) app.getBean("client");
		Customer customer = new Customer();
		customer.setCustomerId("66");
		customer.setPwd("aa");
		customer.setRegisterTime("xx");
		customer.setShowName("dd");
		customer.setTrueName("vv");
//		customer.setUuid(1);
//		client.customerDao.create(customer);
//		client.customerDao.update(customer);
//		Customer c = client.customerDao.getByUuId(1);
//		System.out.println(c);
		CustomerQuery customerQuery = new CustomerQuery();
		customerQuery.getPage().setNowPage(2);
		customerQuery.getPage().setPageShow(3);
		List<Customer> list = client.customerDao.getByConditionPage(customerQuery);
		System.out.println(list);
		
	}
}
