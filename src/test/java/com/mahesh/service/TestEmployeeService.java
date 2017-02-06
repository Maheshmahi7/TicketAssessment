package com.mahesh.service;

import com.mahesh.exception.PersistenceException;
import com.mahesh.exception.ServiceException;

public class TestEmployeeService {

	public static void main(String[] args) {

		EmployeeService employeeService=new EmployeeService();
		/*try {
			employeeService.ticketReassignmnet("arunk@gmail.com", "arunkumar", 4, 4);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/*try {
			employeeService.updateTicket("arunk@gmail.com", "arunkumar", 9, "INPROGRESS");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*
		try {
			employeeService.updateSolution("rajeshraj@gmail.com", "rajeshkumar", 8, "Face it");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	/*	try {
			employeeService.deleteTicket("ramprabu@gmail.com", "ramprabu", 6);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			employeeService.showEmployeeTicket("rajeshraj@gmail.com", "rajeshkumar");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
