package com.jkt.training.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employees {

  	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String empName;
	private String empEmailId;
	private String password;
	private int empLeaveEarned;
	private Employees manager;
	
	public Employees()
	{
		super();
	}
	public Employees(int id, String empName, String empEmailId, String password, int empLeaveEarned,
			Employees manager) {
		super();
		this.id = id;
		this.empName = empName;
		this.empEmailId = empEmailId;
		this.password = password;
		this.empLeaveEarned = empLeaveEarned;
		this.manager = manager;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmailId() {
		return empEmailId;
	}
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEmpLeaveEarned() {
		return empLeaveEarned;
	}
	public void setEmpLeaveEarned(int empLeaveEarned) {
		this.empLeaveEarned = empLeaveEarned;
	}
	public Employees getManager() {
		return manager;
	}
	public void setManager(Employees manager) {
		this.manager = manager;
	}
	
	@Override
	public String toString() {
		return "Employees [id=" + id + ", empName=" + empName + ", empEmailId=" + empEmailId + ", password=" + password
				+ ", empLeaveEarned=" + empLeaveEarned + ", manager=" + manager + "]";
	}
}
