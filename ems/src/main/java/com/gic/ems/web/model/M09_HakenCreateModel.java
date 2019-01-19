package com.gic.ems.web.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dispatch_department")
public class M09_HakenCreateModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "required")
	@NotBlank(message = "required")
	private String contractEmail;
	
	private String contractPersonFirstName;
	
	private String contractPersonLastName;
	
	private String contractPersonFirstNameKana;
	
	private String contractPersonLastNameKana;
	
	@NotNull(message = "required")
	@NotBlank(message = "required")
	private String contractPhone;
	
	private String address;
	
	private String postalCode;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContractEmail() {
		return contractEmail;
	}

	public void setContractEmail(String contractEmail) {
		this.contractEmail = contractEmail;
	}

	public String getContractPersonFirstName() {
		return contractPersonFirstName;
	}

	public void setContractPersonFirstName(String contractPersonFirstName) {
		this.contractPersonFirstName = contractPersonFirstName;
	}

	public String getContractPersonLastName() {
		return contractPersonLastName;
	}

	public void setContractPersonLastName(String contractPersonLastName) {
		this.contractPersonLastName = contractPersonLastName;
	}

	public String getContractPersonFirstNameKana() {
		return contractPersonFirstNameKana;
	}

	public void setContractPersonFirstNameKana(String contractPersonFirstNameKana) {
		this.contractPersonFirstNameKana = contractPersonFirstNameKana;
	}

	public String getContractPersonLastNameKana() {
		return contractPersonLastNameKana;
	}

	public void setContractPersonLastNameKana(String contractPersonLastNameKana) {
		this.contractPersonLastNameKana = contractPersonLastNameKana;
	}

	public String getContractPhone() {
		return contractPhone;
	}

	public void setContractPhone(String contractPhone) {
		this.contractPhone = contractPhone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
