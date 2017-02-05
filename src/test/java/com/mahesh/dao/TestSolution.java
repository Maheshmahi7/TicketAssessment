package com.mahesh.dao;

import com.mahesh.model.Ticket;

public class TestSolution {

	public static void main(String[] args) {

		SolutionDao solutionDao=new SolutionDao();
		
		/*List<Solution> list1=solutionDao.list();  
        
	    for(Solution solution:list1)  
	        System.out.println(solution.getId()+"\t"+solution.getTicketId().getId()+"\t"+solution.getSolution());  
	}  */
		Ticket ticket=new Ticket();
		ticket.setId(8);
		solutionDao.save(ticket);

	}
}

