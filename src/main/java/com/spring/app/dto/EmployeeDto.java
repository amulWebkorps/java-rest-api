package com.spring.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmployeeDto {
	
	private long id;
	
	@NotEmpty(message = "name must not be empty")
	private String name;
	
	@NotEmpty(message = "address must not be empty")
	private String address;
	
	@NotEmpty(message = "email must not be empty")
    @Email(message = "email should be a valid email")
	private String email;
	
	private Long contactno;
	

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contactno
	 */
	public Long getContactno() {
		return contactno;
	}

	/**
	 * @param contactno the contactno to set
	 */
	public void setContactno(Long contactno) {
		this.contactno = contactno;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmployeeDto [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append(", email=");
		builder.append(email);
		builder.append(", contactno=");
		builder.append(contactno);
		builder.append("]");
		return builder.toString();
	}
	
	
}
