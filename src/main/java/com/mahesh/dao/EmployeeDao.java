package com.mahesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mahesh.model.Department;
import com.mahesh.model.Employee;
import com.mahesh.model.Role;
import com.mahesh.util.ConnectionUtil;

public class EmployeeDao {
	
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(Employee employee) {

		String sql = "INSERT INTO TICKET_EMPLOYEES(NAME,DEPARTMENT_ID,ROLE_ID,EMAIL_ID,PASSWORD,MOBILE_NUMBER) VALUES(?,?,?,?,?)";
		Object[] params = { employee.getName(),employee.getDepartmentId().getId(),employee.getRoleId().getId(),employee.getEmailId(),employee.getPassword(),employee.getMobileNumber() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Employee employee) {

		String sql = "UPDATE TICKET_EMPLOYEES SET NAME=?,DEPARTMENT_ID=?,ROLE_ID,MOBILE_NUMBER=? WHERE ID=?";
		Object[] params = { employee.getName(),employee.getDepartmentId().getId(),employee.getRoleId().getId(),employee.getMobileNumber(),employee.getId() };
		jdbcTemplate.update(sql, params);


	}

	public void delete(int id) {

		String sql = "DELETE FROM TICKET_EMPLOYEES WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Employee> list() {

			String sql = "SELECT ID,NAME,DEPARTMENT_ID,ROLE_ID,EMAIL_ID,PASSWORD,MOBILE_NUMBER,ACTIVE FROM TICKET_EMPLOYEES";
			Object[] params={};
			return convert(sql,params);

	}
		
		private List<Employee> convert(String sql, Object[] params) {
		return jdbcTemplate.query(sql,params,new RowMapper<Employee>(){  
		    public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
			Employee employee=new Employee();
			employee.setId(rs.getInt("ID"));
			employee.setName(rs.getString("NAME"));
			Department department=new Department();
			department.setId(rs.getInt("DEPARTMENT_ID"));
			employee.setDepartmentId(department);
			Role role=new Role();
			role.setId(rs.getInt("ROLE_ID"));
			employee.setRoleId(role);
			employee.setEmailId(rs.getString("EMAIL_ID"));
			employee.setPassword(rs.getString("PASSWORD"));
			employee.setMobileNumber(rs.getLong("MOBILE_NUMBER"));
			employee.setActive(rs.getInt("ACTIVE"));
			return employee;

		}});


}
		public String checkPassword(Employee employee)
		{	
			String sql="SELECT PASSWORD FROM TICKET_EMPLOYEES WHERE EMAIL_ID=?";
			Object[] params={employee.getEmailId()};
			return jdbcTemplate.queryForObject(sql,params, (rs, rowNum) -> {
				Employee employees=new Employee();
				employees.setPassword(rs.getString("PASSWORD"));;
				return employees.getPassword();
			});
			
		}
		
		public Employee findEmployeeId(String emailId) {
			String sql = "SELECT ID FROM TICKET_EMPLOYEES WHERE EMAIL_ID = ?";
			Object[] params = { emailId };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
				Employee employee=new Employee();
				employee.setId(rs.getInt("ID"));
				return employee;
			
			});

		}
		
		public Employee findEmployeeDepartmentId(int id) {
			String sql = "SELECT DEPARTMENT_ID FROM TICKET_EMPLOYEES WHERE ID = ?";
			Object[] params = { id };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
				Employee employees=new Employee();
				Department department=new Department();
				department.setId(rs.getInt("DEPARTMENT_ID"));
				employees.setDepartmentId(department);
				return employees;
			
			});

		}
		
		public Employee findEmployeeRoleId(int id) {
			String sql = "SELECT ROLE_ID FROM TICKET_EMPLOYEES WHERE ID = ?";
			Object[] params = { id };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
				Employee employee=new Employee();
				Role role=new Role();
				role.setId(rs.getInt("ROLE_ID"));
				employee.setRoleId(role);
				return employee;
			
			});

		}



}




