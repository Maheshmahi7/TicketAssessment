package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Role;

public class TestRoleDao {

	public static void main(String[] args) {
		
		RoleDao roleDao=new RoleDao();
//		roleDao.save("Manager");
//		
//		Role role=new Role();
//		role.setActive(0);
//		role.setId(4);
//		roleDao.update(role);
//		
//		roleDao.delete(4);
//		
		List<Role> list = roleDao.list();
		Iterator<Role> i = list.iterator();
		while (i.hasNext()) {
			Role roles=(Role) i.next();
			System.out.println(roles.getId()+"\t"+roles.getName()+"\t"+roles.getActive());
		}
		
	}

}
