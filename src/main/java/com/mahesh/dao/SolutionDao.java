package com.mahesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.mahesh.model.Solution;
import com.mahesh.model.Ticket;
import com.mahesh.util.ConnectionUtil;

public class SolutionDao {

	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(Ticket ticket) {

		String sql = "INSERT INTO TICKET_SOLUTIONS(TICKET_ID) VALUES(?)";
		Object[] params = { ticket.getId() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Solution solution) {

		String sql = "UPDATE TICKET_SOLUTIONS SET SOLUTION=? WHERE TICKET_ID=?";
		Object[] params = { solution.getSolution(),solution.getTicketId().getId() };
		jdbcTemplate.update(sql, params);

	}
	

	public void delete(int id) {

		String sql = "DELETE FROM TICKET_SOLUTIONS WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Solution> list() {

			String sql = "SELECT ID,TICKET_ID,SOLUTION FROM TICKET_SOLUTIONS";
			Object[] params={};
			return convert(sql,params);
			}

	/*	private List<Solution> convert1(String sql, Object[] params) {
			return (List<Solution>) jdbcTemplate.query(sql,params, (rs, rowNum) -> {
				Solution solution=new Solution();
				solution.setId(rs.getInt("ID"));
				solution.setSubject(rs.getString("SUBJECT"));
				solution.setSolution(rs.getString("SOLUTION"));
				return solution;

			});
	}*/
		
		private List<Solution> convert(String sql,Object[] params){  
			 return jdbcTemplate.query(sql,params,new RowMapper<Solution>(){  
			    @Override  
			    public Solution mapRow(ResultSet rs, int rownumber) throws SQLException {  
			        Solution solution=new Solution();  
			        solution.setId(rs.getInt("ID"));
			        Ticket ticket=new Ticket();
			        ticket.setId(rs.getInt("TICKET_ID"));
			        solution.setTicketId(ticket);  
			        solution.setSolution(rs.getString("SOLUTION"));  
			        return solution;  
			    }  
			    });  
			}  


}
