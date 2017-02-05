package com.mahesh.dao;

import java.util.List;

import com.mahesh.model.Solution;

public class TestSolution {

	public static void main(String[] args) {

		SolutionDao solutionDao=new SolutionDao();
		
		List<Solution> list1=solutionDao.list();  
        
	    for(Solution solution:list1)  
	        System.out.println(solution.getId()+"\t"+solution.getSubject()+"\t"+solution.getSolution());  
	}  

	}

