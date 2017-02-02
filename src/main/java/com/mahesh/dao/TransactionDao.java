package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Department;
import com.mahesh.model.Employee;
import com.mahesh.model.Priority;
import com.mahesh.model.Transaction;
import com.mahesh.model.User;
import com.mahesh.util.ConnectionUtil;

public class TransactionDao {
	
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(Transaction transaction) {
		String sql = "INSERT INTO TICKET_TRANSACTION(USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY_ID) VALUES(?,?,?,?,?)";
		Object[] params={transaction.getUserId().getId(),transaction.getDepartmentId().getId(),transaction.getSubject(),transaction.getDescription(),transaction.getPriorityId().getId()};
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Transaction transaction) {

		String sql = "UPDATE TICKET_TRANSACTION SET EMPLOYEE_ID=? WHERE ID=?";
		Object[] params={ transaction.getEmployeeId().getId(),transaction.getId()};
		jdbcTemplate.update(sql, params);

	}

	
	public void delete(int id) {

		String sql = "DELETE FROM TICKET_TRANSACTION WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Transaction> list() {

			String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY,EMPLOYEE_ID,CREATED_DATE,CLOSED_DATE,STATUS FROM TICKET_TRANSACTION";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				Transaction transaction=new Transaction();
				transaction.setId(rs.getInt("ID"));
				User user=new User();
				user.setId(rs.getInt("USER_ID"));
				transaction.setUserId(user);
				Department department=new Department();
				department.setId(rs.getInt("DEPARTMENT_ID"));
				transaction.setDepartmentId(department);
				transaction.setSubject(rs.getString("SUBJECT"));
				transaction.setDescription(rs.getString("DESCRIPTION"));
				Priority priority=new Priority();
				priority.setId(rs.getInt("PRIORITY_ID"));
				transaction.setPriorityId(priority);
				Employee employee=new Employee();
				employee.setId(rs.getInt("EMPLOYEE_ID"));
				transaction.setEmployeeId(employee);
				transaction.setCreatedDate(rs.getDate("CREATED_DATE").toLocalDate());
				transaction.setClosedDate(rs.getDate("CLOSED_DATE").toLocalDate());
				transaction.setStatus(rs.getString("STATUS"));
				return transaction;

			});


	}



}
