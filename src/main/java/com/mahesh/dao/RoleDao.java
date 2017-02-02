package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mahesh.model.Role;
import com.mahesh.util.ConnectionUtil;

public class RoleDao {
	
	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(String name) {

		String sql = "INSERT INTO TICKET_ROLES(NAME) VALUES(?)";
		Object[] params = { name };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(Role role) {

		String sql = "UPDATE TICKET_ROLES SET ACTIVE=? WHERE ID=?";
		Object[] params = { role.getActive(),role.getId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {

		String sql = "DELETE FROM TICKET_ROLES WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<Role> list() {

			String sql = "SELECT ID,NAME,ACTIVE FROM TICKET_ROLES";
			Object[] params={};
			return convert(sql,params);
			}

		private List<Role> convert(String sql, Object[] params) {
			return (List<Role>) jdbcTemplate.query(sql,params, (rs, rowNum) -> {
				Role role=new Role();
				role.setId(rs.getInt("ID"));
				role.setName(rs.getString("NAME"));
				role.setActive(rs.getInt("ACTIVE"));
				return role;

			});
	}


}
