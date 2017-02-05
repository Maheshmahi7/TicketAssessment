package com.mahesh.dao;

//import java.util.Iterator;
//import java.util.List;
//
//import com.mahesh.model.Employee;

public class TestEmployeeDao {

	public static void main(String[] args) {
		
		EmployeeDao employeeDao=new EmployeeDao();
		
		/*Employee employee=new Employee();
		Department department=new Department();
		employee.setName("Arun");
		department.setId(3);
		employee.setDepartmentId(department);
		employee.setEmailId("arun@gmail.com");
		employee.setPassword("arunkumar");
		employee.setMobileNumber(852682870);
		employeeDao.save(employee);
		
		
		employee.setName("Arunkumar");
		department.setId(2);
		employee.setDepartmentId(department);
		employee.setMobileNumber(774455668);
		employee.setId(5);
		employeeDao.update(employee);
		*/
		//employeeDao.delete(5);
		
		/*List<Employee> list = employeeDao.list();
		Iterator<Employee> i = list.iterator();
		while (i.hasNext()) {
			Employee employees=(Employee) i.next();
			System.out.println(employees.getId()+"\t"+employees.getName()+"\t"+employees.getDepartmentId().getId()+"\t"+employees.getRoleId().getId()+"\t"+employees.getEmailId()+"\t"+employees.getPassword()
			+"\t"+employees.getMobileNumber()+"\t"+employees.getActive());
		}*/
		
		int id=2;
		System.out.println(employeeDao.findEmployeeDepartmentId(id).getDepartmentId().getId());

	}

}
