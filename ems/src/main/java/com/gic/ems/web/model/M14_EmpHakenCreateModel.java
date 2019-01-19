package com.gic.ems.web.model;

import java.io.Serializable;

public class M14_EmpHakenCreateModel implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String companyId;
	private String employeeId;
	private String employeeName;
	private String groupId;
	private String dispatchDept;
	private String dispatchStartDate;
	private String dispatchEndDate;
	private String income;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getDispatchDept() {
		return dispatchDept;
	}
	public void setDispatchDept(String dispatchDept) {
		this.dispatchDept = dispatchDept;
	}
	public String getDispatchStartDate() {
		return dispatchStartDate;
	}
	public void setDispatchStartDate(String dispatchStartDate) {
		this.dispatchStartDate = dispatchStartDate;
	}
	public String getDispatchEndDate() {
		return dispatchEndDate;
	}
	public void setDispatchEndDate(String dispatchEndDate) {
		this.dispatchEndDate = dispatchEndDate;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	
	
	
}
