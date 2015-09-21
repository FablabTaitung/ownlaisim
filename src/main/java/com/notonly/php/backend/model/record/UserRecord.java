package com.notonly.php.backend.model.record;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class UserRecord {

	/*
	@Id
    @GeneratedValue(generator="UserRecordGenerator")
    @TableGenerator(name="UserRecordGenerator", table="ID_GEN",
        pkColumnName="ID_NAME", valueColumnName="ID_VAL",
        pkColumnValue="USR_REC_GEN")
	private long id;
	*/
	
	@Id
	String userId = "";
	String password = "";
	
	String name = "";
	String mobile = "";
	String phone = "";
	String fax = "";
	String address = "";
	String eMail = "";
	
//	public long getId() {
//		return id;
//	}
	
//	public void setId(long id) {
//		this.id = id;
//	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getFax() {
		return fax;
	}
	
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String geteMail() {
		return eMail;
	}
	
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	
	
}
