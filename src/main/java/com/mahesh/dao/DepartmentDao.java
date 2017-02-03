package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Department;
import com.mahesh.util.ConnectionUtil;

public class DepartmentDao {
	
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(String name) {

		String sql = "INSERT INTO TICKET_DEPARTMENTS(NAME) VALUES(?)";
		jdbcTemplate.update(sql, name);

	}
	
	public void update(Department department) {

		String sql = "UPDATE TICKET_DEPARTMENTS SET ACTIVE=? WHERE ID=?";
		Object[] params={ department.getActive(),department.getId()};
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {

		String sql = "DELETE FROM TICKET_DEPARTMENTS WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Department> list() {

			String sql = "SELECT ID,NAME,ACTIVE FROM TICKET_DEPARTMENTS";
			Object[] params={};
			return convert(sql,params);

	}
		private List<Department> convert(String sql, Object[] params) {
			return (List<Department>) jdbcTemplate.query(sql,params, (rs, rowNum) -> {
				Department department=new Department();
				department.setId(rs.getInt("ID"));
				department.setName(rs.getString("NAME"));
				department.setActive(rs.getInt("ACTIVE"));
				return department;

			});


	}
		public Department findDepartmentId(String departmentName) {
			String sql = "SELECT ID FROM TICKET_DEPARTMENTS WHERE NAME = ?";
			Object[] params = { departmentName };
			return jdbcTemplate.queryForObject(sql, params, (rs, rowNo) -> {
				Department department=new Department();
				department.setId(rs.getInt("ID"));
				return department;
			
			});

		}




}
