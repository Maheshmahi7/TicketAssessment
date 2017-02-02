package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Priority;

public class TestPriorityDao {

	public static void main(String[] args) {
		
		PriorityDao priorityDao=new PriorityDao();
		priorityDao.save("Very Low");
		
		Priority priority=new Priority();
		priority.setActive(0);
		priority.setId(4);
		priorityDao.update(priority);
		
		priorityDao.delete(4);
		
		List<Priority> list = priorityDao.list();
		Iterator<Priority> i = list.iterator();
		while (i.hasNext()) {
			Priority prioritys=(Priority) i.next();
			System.out.println(prioritys.getId()+"\t"+prioritys.getName()+"\t"+prioritys.getActive());
		}
		
	}

}
