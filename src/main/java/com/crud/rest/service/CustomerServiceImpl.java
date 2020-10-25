package com.crud.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.crud.rest.beans.MyCustomer;
import com.crud.rest.dao.CustomerDao;

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	//setter for customerDao
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public MyCustomer findById(long id) {

		return customerDao.findById(id);
	}

	@Override
	public MyCustomer findByName(String name) {

		return customerDao.findByName(name);
	}

	@Override
	public void saveCustomer(MyCustomer Customer) {
		customerDao.saveCustomer(Customer);

	}

	@Override
	public void updateCustomer(MyCustomer Customer) {
		customerDao.updateCustomer(Customer);

	}

	@Override
	public void deleteCustomerById(long id) {
		customerDao.deleteCustomerById(id);

	}

	@Override
	public List<MyCustomer> findAllCustomers() {

		return customerDao.findAllCustomers();
	}

	@Override
	public void deleteAllCustomers() {
		customerDao.deleteAllCustomers();

	}

	@Override
	public boolean isCustomerExist(MyCustomer Customer) {

		return customerDao.isCustomerExist(Customer);
	}

}
