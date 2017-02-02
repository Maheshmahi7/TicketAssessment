package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Department;
import com.mahesh.model.Employee;
import com.mahesh.model.Priority;
import com.mahesh.model.Ticket;
import com.mahesh.model.User;
import com.mahesh.util.ConnectionUtil;

public class TicketDao {
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(Ticket ticket) {
		String sql = "INSERT INTO TICKET_TICKETS(USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY_ID) VALUES(?,?,?,?,?)";
		Object[] params={ticket.getUserId().getId(),ticket.getDepartmentId().getId(),ticket.getSubject(),ticket.getDescription(),ticket.getPriorityId().getId()};
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Ticket ticket) {

		String sql = "UPDATE TICKET_TICKETS SET EMPLOYEE_ID=? WHERE ID=?";
		Object[] params={ ticket.getEmployeeId().getId(),ticket.getId()};
		jdbcTemplate.update(sql, params);

	}

	
	public void delete(int id) {

		String sql = "DELETE FROM TICKET_TICKETS WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Ticket> list() {

			String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY_ID,EMPLOYEE_ID,CREATED_DATE,CLOSED_DATE,STATUS FROM TICKET_TICKETS";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				Ticket ticket=new Ticket();
				ticket.setId(rs.getInt("ID"));
				User user=new User();
				user.setId(rs.getInt("USER_ID"));
				ticket.setUserId(user);
				Department department=new Department();
				department.setId(rs.getInt("DEPARTMENT_ID"));
				ticket.setDepartmentId(department);
				ticket.setSubject(rs.getString("SUBJECT"));
				ticket.setDescription(rs.getString("DESCRIPTION"));
				Priority priority=new Priority();
				priority.setId(rs.getInt("PRIORITY_ID"));
				ticket.setPriorityId(priority);
				Employee employee=new Employee();
				employee.setId(rs.getInt("EMPLOYEE_ID"));
				ticket.setEmployeeId(employee);
				ticket.setCreatedDate(rs.getDate("CREATED_DATE").toLocalDate());
				ticket.setClosedDate(rs.getDate("CLOSED_DATE").toLocalDate());
				ticket.setStatus(rs.getString("STATUS"));
				return ticket;

			});


	}




}