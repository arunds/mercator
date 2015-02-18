package com.drishticon.mercator.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

/**
 * @author Arun S
 *
 */
@Entity
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 2825178463422023352L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(name="customer_code")
	@NaturalId
	private String customerCode;

	@Column(name="cust_name")
	private String customerName;
	
	@Column(name="cust_description")
	private String customerDescription;
	
	@Column(name="cust_status")
	private String customerStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerDescription() {
		return customerDescription;
	}

	public void setCustomerDescription(String customerDescription) {
		this.customerDescription = customerDescription;
	}

	public String getCustomerStatus() {
		return customerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		this.customerStatus = customerStatus;
	}

}
