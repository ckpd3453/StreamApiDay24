package com.StreamApi;

public class ServerBook12 {
	
	public ServerBook12() {
		super();
	}


	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zipNo;
	private long phoneNo;
	private String email;
	
	
	
	public ServerBook12(String firstName, String lastName, String address, String city, String state, int zipNo,
			long phoneNo, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipNo = zipNo;
		this.phoneNo = phoneNo;
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getZipNo() {
		return zipNo;
	}


	public void setZipNo(int zipNo) {
		this.zipNo = zipNo;
	}


	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "\n ServerBook [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
				+ city + ", state=" + state + ", zipNo=" + zipNo + ", phoneNo=" + phoneNo + ", email=" + email + "]";
	}
	
	
	
}
