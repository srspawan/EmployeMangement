package com.wipro.employee.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "employee")
@Component
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String dep;

	public Employee() {

	}

	public Employee(int id, String name, String dep) {
		super();
		this.id = id;
		this.name = name;
		this.dep = dep;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dep=" + dep + "]";
	}

}
