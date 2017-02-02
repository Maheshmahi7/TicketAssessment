package com.mahesh.model;

public class TestEmployee {

	public static void main(String[] args) {


		Employee employee=new Employee();
		employee.setId(1);
		employee.setName("Rajesh");
		Department department=new Department();
		department.setId(1);
		employee.setDepartmentId(department);
		Role role=new Role();
		role.setId(1);
		employee.setRoleId(role);
		employee.setEmailId("mahesh@gmail.com");
		employee.setPassword("rajesh");
		employee.setMobileNumber(852682870);
		employee.setActive(1);
		
		System.out.println(employee);


	}

}
