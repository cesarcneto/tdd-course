package br.com.atech.tddcourse.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = "Employee.listOrderByNameDesc", query = "SELECT e FROM Employee e ORDER BY e.name DESC") })
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToOne
	private Department department;

	public Employee() {
	}

	public Employee(final String name) {
		this.name = name;
	}

	public Employee(final String name, final Department department) {
		this.name = name;
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDepartment(final Department department) {
		this.department = department;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", department=" + department.getName() + "]";
	}

}
