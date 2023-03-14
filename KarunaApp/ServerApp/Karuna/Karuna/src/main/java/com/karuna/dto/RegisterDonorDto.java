package com.karuna.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.karuna.entity.BaseEntity;

public class RegisterDonorDto extends BaseEntity{
	
	
	private String name;
	private Long phone;
	
	@NotBlank(message = "Email can't be blank!")
	@Email(message = "Invalid Email Format")
	@Length(min = 5,max=20,message = "Invalid Email length!!!!!!!")
	private String email;
	
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Blank or Invalid Password!!!!")
	private String password;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public RegisterDonorDto(String name, Long phone,
			@NotBlank(message = "Email can't be blank!") @Email(message = "Invalid Email Format") @Length(min = 5, max = 20, message = "Invalid Email length!!!!!!!") String email,
			@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Blank or Invalid Password!!!!") String password,
			String address) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.address = address;
	}
	public RegisterDonorDto() {
		super();
	}
	@Override
	public String toString() {
		return "RegisterDonorDto [name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address
				+ "]";
	}
	public Long getId() {
		return super.getId();
	}
	
	

}
