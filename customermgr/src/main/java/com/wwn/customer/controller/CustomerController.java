package com.wwn.customer.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wwn.customer.entity.Customer;
import com.wwn.customer.entity.CustomerQuery;
import com.wwn.customer.pageutil.Page;
import com.wwn.customer.service.CustomerService;
import com.wwn.customer.util.DateUtil;
import com.wwn.customer.util.JsonUtil;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="toAdd",method=RequestMethod.GET)
	public String toAdd() 
	{
		return "customer/add";
	}
	
	@RequestMapping(value="add")
	public String add(Customer customer,Model model) 
	{
		customer.setRegisterTime(DateUtil.dateToString(new Date(System.currentTimeMillis())));
		int result = customerService.create(customer);
		if(result > 0)
		{
			model.addAttribute("opertion", "添加数据成功");
		}
		else
		{
			model.addAttribute("opertion", "添加数据失败");
		}
		return "customer/success";
	}
	
	@RequestMapping(value="toUpdate/{customerUuid}")
	public String toUpdate(@PathVariable("customerUuid") int customerUuid,Model model)
	{
		Customer customer = customerService.getByUuId(customerUuid);
		model.addAttribute("customer", customer);
		return "customer/update";
	}
	
	public String updata(Customer customer,Model model)
	{
		int result = customerService.update(customer);
		if(result > 0)
		{
			model.addAttribute("opertion", "更新数据成功");
		}
		else
		{
			model.addAttribute("opertion", "更新数据失败");
		}
		return "customer/success";
	}
	
	@RequestMapping(value="delete/{customerId}")
	public String delete(@PathVariable("customerId") int customerId,Model model)
	{
		int result = customerService.delete(customerId);
		if(result > 0)
		{
			model.addAttribute("opertion", "更新数据成功");
		}
		else
		{
			model.addAttribute("opertion", "更新数据失败");
		}
		return "customer/success";
	}
	
	@RequestMapping(value="toList")
	public String toList(Model model,@RequestParam(required=false) int nowPage,String queryCondition)
	{
		Page<Customer> page = null;
		List<Customer> list = new ArrayList<Customer>();
		if(queryCondition == null || "".equals(queryCondition) || queryCondition.length() == 0)
		{
			page = new Page<Customer>();
		}
		else
		{
			CustomerQuery customerQuery = (CustomerQuery) JsonUtil.strToObject(queryCondition, Customer.class);
			list = customerService.getByConditionPage(customerQuery);
			page = customerQuery.getPage();
		}
		page.setNowPage(nowPage);
		page.setResult(list);
		model.addAttribute("page",page);
		return "/customer/list";
	}
}
