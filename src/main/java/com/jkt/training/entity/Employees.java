package com.jkt.training.entity;
import javax.persistence.Entity;

@Entity
public class Employees {

  private String EmpId;
	private String EmpName;
	private String EmpEmailId;
	private String Password;
	private int EmpLeaveEarned;
	private Employees Manager;
	public String getEmpId() {
		return EmpId;
	}
	public void setEmpId(String empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public String getEmpEmailId() {
		return EmpEmailId;
	}
	public void setEmpEmailId(String empEmailId) {
		EmpEmailId = empEmailId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getEmpLeaveEarned() {
		return EmpLeaveEarned;
	}
	public void setEmpLeaveEarned(int empLeaveEarned) {
		EmpLeaveEarned = empLeaveEarned;
	}
	public Employees getManager() {
		return Manager;
	}
	public void setManager(Employees manager) {
		Manager = manager;
	}
	
	
	@Override
	public String toString() {
		return "Employees [EmpId=" + EmpId + ", EmpName=" + EmpName + ", EmpEmailId=" + EmpEmailId + ", Password="
				+ Password + ", EmpLeaveEarned=" + EmpLeaveEarned + ", Manager=" + Manager + "]";
	}
}
