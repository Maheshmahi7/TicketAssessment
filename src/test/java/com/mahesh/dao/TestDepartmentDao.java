package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Department;

public class TestDepartmentDao {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao=new DepartmentDao();
		
		/*Department department=new Department();
		//departmentDao.save("MANAGING TEAM");
		
		
		department.setActive(0);
		department.setId(5);
		departmentDao.update(department);
		*/
		departmentDao.delete(5);
		List<Department> list = departmentDao.list();
		Iterator<Department> i = list.iterator();
		while (i.hasNext()) {
			Department departments=(Department) i.next();
			System.out.println(departments.getId()+"\t"+departments.getName()+"\t"+departments.getActive());
		}
	}

}
