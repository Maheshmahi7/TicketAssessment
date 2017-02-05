package com.mahesh.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import com.mahesh.model.Solution;
import com.mahesh.util.ConnectionUtil;

public class SolutionDao {

	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(String subject) {

		String sql = "INSERT INTO TICKET_SOLUTIONS(SUBJECT) VALUES(?)";
		Object[] params = { subject };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Solution solution) {

		String sql = "UPDATE TICKET_SOLUTIONS SET SOLUTION=? WHERE ID=?";
		Object[] params = { solution.getSolution(),solution.getId() };
		jdbcTemplate.update(sql, params);

	}
	

	public void delete(int id) {

		String sql = "DELETE FROM TICKET_SOLUTIONS WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Solution> list() {

			String sql = "SELECT ID,SUBJECT,SOLUTION FROM TICKET_SOLUTIONS";
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
			        Solution s=new Solution();  
			        s.setId(rs.getInt("ID"));  
			        s.setSubject(rs.getString("SUBJECT"));  
			        s.setSolution(rs.getString("SOLUTION"));  
			        return s;  
			    }  
			    });  
			}  


}
