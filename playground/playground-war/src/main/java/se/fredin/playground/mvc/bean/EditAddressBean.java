package se.fredin.playground.mvc.bean;

import javax.validation.Valid;

import se.fredin.playground.domain.entitiy.Address;

public class EditAddressBean {

	@Valid
	private Address address;
	
	public EditAddressBean() {}
	
	public EditAddressBean(Address address) {
		setAddress(address);
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	
}
