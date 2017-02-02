package com.mahesh.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


import com.mahesh.model.User;
import com.mahesh.util.ConnectionUtil;

public class UserDao {

	JdbcTemplate jdbcTemplate=ConnectionUtil.getJdbcTemplate();
	
	public void save(User user) {

		String sql = "INSERT INTO TICKET_USERS(NAME,EMAIL_ID,PASSWORD,MOBILE_NUMBER) VALUES(?,?,?,?)";
		Object[] params = { user.getName(),user.getEmailId(),user.getPassword(),user.getMobileNumber() };
		jdbcTemplate.update(sql, params);

	}
	
	public void update(User user) {

		String sql = "UPDATE TICKET_USERS SET NAME=?,MOBILE_NUMBER=? WHERE ID=?";
		Object[] params = { user.getName(),user.getMobileNumber(),user.getId() };
		jdbcTemplate.update(sql, params);

	}

	public void delete(int id) {

		String sql = "DELETE FROM TICKET_USERS WHERE ID=?";
		jdbcTemplate.update(sql, id);
		
	}
		
		public List<User> list() {

			String sql = "SELECT ID,NAME,EMAIL_ID,PASSWORD,MOBILE_NUMBER,ACTIVE FROM TICKET_USERS";
			Object[] params={};
			return convert(sql,params);
}
		
		private List<User> convert(String sql, Object[] params) {
			return (List<User>) jdbcTemplate.query(sql,params, (rs, rowNum) -> {
				User user=new User();
				user.setId(rs.getInt("ID"));
				user.setName(rs.getString("NAME"));
				user.setEmailId(rs.getString("EMAIL_ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setMobileNumber(rs.getLong("MOBILE_NUMBER"));
				user.setActive(rs.getInt("ACTIVE"));
				return user;

			});
}

}