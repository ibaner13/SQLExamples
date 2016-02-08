package com.training.daos;

import java.sql.*;
import java.util.*;
import com.training.entity.Customer;
import com.training.ifaces.DAO;
import com.training.utils.SqlConnection;

public class CustomerDAO implements DAO<Customer> {

	private Connection con;

	public CustomerDAO() {
		super();
		con = SqlConnection.getOracleConnection();
	}

	public CustomerDAO(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public int add(Customer t) {
		String sql = "Insert into Customer values(?,?,?,?)";
		int rowAdded = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getCustomerId());
			pstmt.setString(2, t.getCustomerName());
			pstmt.setLong(3, t.getHandPhone());
			pstmt.setString(4, t.getEmail_Id());
			rowAdded = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowAdded;
	}

	@Override
	public Customer find(int key) {
		String sql = "Select * from Customer where custId = ?";
		Customer cust = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				cust = getCustomer(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cust;
	}

	private Customer getCustomer(ResultSet rs) {
		Customer cust = null;
		try {
			int custId = rs.getInt("custId");
			String custName = rs.getString("custName");
			long handPhone = rs.getLong("handPhone");
			String emailId = rs.getString("email");
			cust = new Customer(custId, custName, emailId, handPhone);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cust;
	}

	@Override
	public List<Customer> findAll() {
		ArrayList<Customer> custList = new ArrayList<Customer>();
		String sql = "Select * from Customer";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Customer cust = getCustomer(rs);
				custList.add(cust);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return custList;
	}

	@Override
	public int update(int key) {
		String sql = "Update Customer Set custName = ? where custId = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "Dhawal");
			pstmt.setInt(2, 103);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result == 0)
			return 0;
		else
			return key;
	}

	@Override
	public int delete(int key) {
		String sql = "Delete from Customer where custId = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, key);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result == 0)
			return 0;
		else
			return key;
	}

}
