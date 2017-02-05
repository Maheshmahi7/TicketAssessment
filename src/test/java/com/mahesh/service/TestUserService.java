package com.mahesh.service;

import com.mahesh.exception.PersistenceException;
import com.mahesh.exception.ServiceException;
//import com.mahesh.exception.ValidatorException;

public class TestUserService {

	public static void main(String[] args) {
			UserService userService=new UserService();
	/*		try {
				userService.registration("Mahesh", "www.amss.com@gmail.com", "arunkumar", 986538431);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ValidatorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
*/
			try {
				userService.newTicket("www.amss.com@gmail.com", "arunkumar", "Reg Refund Issues", "Didnot received the refund yet for my product", "FINANCE TEAM", "HIGH");
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PersistenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
	}

}
