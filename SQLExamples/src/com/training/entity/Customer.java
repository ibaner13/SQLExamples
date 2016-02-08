package com.training.entity;

public class Customer {

	private int custId;
	private String custName;
	private String email_Id;
	private long handPhone;

	public Customer() {
		super();
	}

	// Declare Rule

	public Customer(int customerId, String customerName, String email_Id, long handPhone) {
		super();
		this.custId = customerId;
		this.custName = customerName;
		this.email_Id = email_Id;
		this.handPhone = handPhone;
//		if (handPhone > 999999999L || handPhone < 1111111111L) {
//			try {
//				throw new RangeCheckException(handPhone);
//			} catch (RangeCheckException e) {
//				System.out.println(e.getMessage());
//			}
//		} else {
//			this.handPhone = handPhone;
//		}
	}

	public int getCustomerId() {
		return custId;
	}

	public void setCustomerId(int customerId) {
		this.custId = customerId;
	}

	public String getCustomerName() {
		return custName;
	}

	public void setCustomerName(String customerName) {
		this.custName = customerName;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public long getHandPhone() {
		return handPhone;
	}

//	public void setHandPhone(long handPhone) throws RangeCheckException {
//		if (handPhone > 9999999999L) {
//			throw new RangeCheckException(handPhone);
//		} else {
//			this.handPhone = handPhone;
//		}
//	}

	public String showCustomer() {

		String custDetails = custId + " : " + custName + " : " + email_Id + " : " + handPhone;

		return custDetails;

	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", email_Id=" + email_Id + ", handPhone="
				+ handPhone + "]";
	}

}