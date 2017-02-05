package com.mahesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mahesh.model.Department;
import com.mahesh.model.Employee;
import com.mahesh.model.Priority;
import com.mahesh.model.Ticket;
import com.mahesh.model.User;
import com.mahesh.util.ConnectionUtil;

public class TicketDao {
	
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(Ticket ticket) {
		String sql = "INSERT INTO TICKET_TICKETS(USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY_ID,EMPLOYEE_ID) VALUES(?,?,?,?,?,?)";
		Object[] params={ticket.getUserId().getId(),ticket.getDepartmentId().getId(),ticket.getSubject(),ticket.getDescription(),ticket.getPriorityId().getId(),ticket.getEmployeeId().getId()};
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Ticket ticket) {

		String sql = "UPDATE TICKET_TICKETS SET DESCRIPTION=? WHERE ID=? AND USER_ID=?";
		Object[] params={ ticket.getDescription(),ticket.getId(),ticket.getUserId().getId()};
		jdbcTemplate.update(sql, params);

	}
	
	public void employeeUpdate(Ticket ticket){
		
		String sql="UPDATE TICKET_TICKETS SET STATUS=? WHERE ID=? AND EMPLOYEE_ID=?";
		Object[] params={ticket.getStatus(),ticket.getId(),ticket.getEmployeeId().getId()};
		jdbcTemplate.update(sql,params);
		
	}
	
	public void ticketReassign(Ticket ticket){

		String sql="UPDATE TICKET_TICKETS SET EMPLOYEE_ID=? WHERE ID=?";
		Object[] params={ticket.getEmployeeId().getId(),ticket.getId()};
		jdbcTemplate.update(sql, params);
	}
	

	
	public void delete(int id) {

		String sql = "DELETE FROM TICKET_TICKETS WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
	
	public void close(Ticket ticket){
		
		String sql = "UPDATE TICKET_TICKETS SET STATUS=?,CLOSED_DATE=CURRENT_TIMESTAMP() WHERE ID=? AND USER_ID=?";
		Object[] params={ ticket.getStatus(),ticket.getId(),ticket.getUserId().getId()};
		jdbcTemplate.update(sql, params);

	}
	
	public Ticket findStatus(int id,User userId)
	{
		String sql = "SELECT STATUS FROM TICKET_TICKETS WHERE ID=? AND USER_ID=?";
		Object[] params={id,userId.getId()};
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Ticket ticket=new Ticket();
			ticket.setStatus(rs.getString("STATUS"));
			return ticket;
		});

	}
	
	public Ticket findTicketId(User userId)
	{
		String sql = "SELECT ID FROM TICKET_TICKETS WHERE USER_ID=? ORDER BY ID DESC LIMIT 1";
		Object[] params={userId.getId()};
		return jdbcTemplate.queryForObject(sql, params, (rs, rowNum) -> {
			Ticket ticket=new Ticket();
			ticket.setId(rs.getInt("ID"));;
			return ticket;
		});

	}

		
		public List<Ticket> selectAll() {

			String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY_ID,EMPLOYEE_ID,CREATED_DATE,SOLUTION_ID,CLOSED_DATE,STATUS FROM TICKET_TICKETS";
			Object[] params={};
			return jdbcTemplate.query(sql,params,new RowMapper<Ticket>(){    
			    public Ticket mapRow(ResultSet rs, int rownumber) throws SQLException {
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

			    }});
	}

		private List<Ticket> convert(String sql, Object[] params) {
			return (List<Ticket>) jdbcTemplate.query(sql,params, (rs, rowNum) -> {
				Ticket ticket=new Ticket();
				ticket.setId(rs.getInt("ID"));
				User users=new User();
				users.setId(rs.getInt("USER_ID"));
				ticket.setUserId(users);
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
				ticket.setStatus(rs.getString("STATUS"));
				return ticket;

			});
		}
		
	
		public List<Ticket> selectByUserId(User user) {

			String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY_ID,EMPLOYEE_ID,CREATED_DATE,STATUS FROM TICKET_TICKETS WHERE USER_ID=?";
			Object[] params={user.getId()};
			return convert(sql,params);
	}
		

		public List<Ticket> selectByEmployeeId(Employee employee) {

			String sql = "SELECT ID,USER_ID,DEPARTMENT_ID,SUBJECT,DESCRIPTION,PRIORITY_ID,EMPLOYEE_ID,CREATED_DATE,STATUS FROM TICKET_TICKETS WHERE EMPLOYEE_ID=?";
			Object[] params={employee.getId()};
			return convert(sql,params);
	}
		
		

}
