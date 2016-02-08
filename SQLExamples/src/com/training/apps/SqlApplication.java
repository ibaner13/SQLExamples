package com.training.apps;

import com.training.daos.CustomerDAO;
import com.training.entity.Customer;

public class SqlApplication {

	public static void main(String[] args) {

//		System.out.println(SqlConnection.getOracleConnection());
		
		Customer cust = new Customer(105, "Ishika", "ish00@gmail.com", 98864);
		CustomerDAO dao = new CustomerDAO(); //Connection Establishment
		int rowAdded = dao.add(cust);
		System.out.println(rowAdded + " : Row(s) Added");
		
		
		/*
		 * Create a customer obj and store the returned cust object from find() method and print it
		 */
		Customer cust1 = dao.find(103);
		System.out.println(cust1);
		System.out.println(dao.update(103));
		//System.out.println(dao.delete(105));
	}

}
