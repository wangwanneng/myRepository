package com.wwn.customer.entity;

import java.io.Serializable;

import com.wwn.customer.pageutil.Page;

/**
 * 封装Customer查询条件
 * @author 王万能
 *
 */
public class CustomerQuery extends Customer implements Serializable{

	private static final long serialVersionUID = -8177392795131981081L;
	 
	private Page<Customer> page = new Page<Customer>();

	public Page<Customer> getPage() {
		return page;
	}

	public void setPage(Page<Customer> page) {
		this.page = page;
	}
}
