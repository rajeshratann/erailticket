package com.kirosys.eticket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer_Details")
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    @Column(name="CUST_FIRST_NAME")
	private String custFirstName;
    
    @Column(name="CUST_MIDDLE_NAME")
	private String custMidName;
    
    @Column(name="CUST_LAST_NAME")
	private String custLastName;
    
    @Column(name="CUST_MOBILE")
	private String custMobile;
    
    @Column(name="LOCAL_ADDRESS")
	private String localAddress;
    
    @Column(name="PERM_ADDRESS")
	private String permanentAddress;
    
    @Column(name="CUST_IDENTITY")
	private String cusIdentity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustFirstName() {
		return custFirstName;
	}

	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}

	public String getCustMidName() {
		return custMidName;
	}

	public void setCustMidName(String custMidName) {
		this.custMidName = custMidName;
	}

	public String getCustLastName() {
		return custLastName;
	}

	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getCusIdentity() {
		return cusIdentity;
	}

	public void setCusIdentity(String cusIdentity) {
		this.cusIdentity = cusIdentity;
	}

	@Override
	public String toString() {
		return "CustomerDetails [id=" + id + ", custFirstName=" + custFirstName + ", custMidName=" + custMidName
				+ ", custLastName=" + custLastName + ", custMobile=" + custMobile + ", localAddress=" + localAddress
				+ ", permanentAddress=" + permanentAddress + ", cusIdentity=" + cusIdentity + "]";
	}
	
	
}
