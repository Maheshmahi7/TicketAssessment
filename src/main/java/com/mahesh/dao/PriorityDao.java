package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Priority;
import com.mahesh.util.ConnectionUtil;

public class PriorityDao {
	
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(String name) {

		String sql = "INSERT INTO TICKET_PRIORITYS(NAME) VALUES(?)";
		Object[] params = { name };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Priority priority) {

		String sql = "UPDATE TICKET_PRIORITYS SET ACTIVE=? WHERE ID=?";
		Object[] params = { priority.getActive(),priority.getId() };
		jdbcTemplate.update(sql, params);


	}

	public void delete(int id) {

		String sql = "DELETE FROM TICKET_PRIORITYS WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Priority> list() {

			String sql = "SELECT ID,NAME,ACTIVE FROM TICKET_PRIORITYS";
			return jdbcTemplate.query(sql, (rs, rowNum) -> {
				Priority priority=new Priority();
				priority.setId(rs.getInt("ID"));
				priority.setName(rs.getString("NAME"));
				priority.setActive(rs.getInt("ACTIVE"));
				return priority;

			});


	}



}
