package com.crud.rest.dao;

import java.util.List;

import com.crud.rest.beans.MyCustomer;

public interface CustomerDao {

	MyCustomer findById(long id);

	MyCustomer findByName(String name);

	void saveCustomer(MyCustomer Customer);

	void updateCustomer(MyCustomer Customer);

	void deleteCustomerById(long id);

	List<MyCustomer> findAllCustomers();

	void deleteAllCustomers();

	boolean isCustomerExist(MyCustomer Customer);
}
