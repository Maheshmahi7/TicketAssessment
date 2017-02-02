package com.mahesh.dao;

import java.util.Iterator;
import java.util.List;

import com.mahesh.model.Transaction;
/*import com.mahesh.model.Department;
import com.mahesh.model.Employee;
import com.mahesh.model.Priority;
import com.mahesh.model.User;
*/
public class TestTransactionDao {

	public static void main(String[] args) {
		TransactionDao transactionDao=new TransactionDao();
		
/*		Transaction transaction = new Transaction();
		User user = new User();
		user.setId(1);
		transaction.setUserId(user);
		Department department = new Department();
		department.setId(1);
		transaction.setDepartmentId(department);
		transaction.setSubject("Reg Mobile");
		transaction.setDescription("Black Mobile");
		Priority priority=new Priority();
		priority.setId(2);
		transaction.setPriorityId(priority);
		transactionDao.save(transaction);
		
		Employee employee=new Employee();
		employee.setId(2);
		transaction.setEmployeeId(employee);
		transaction.setId(5);
		transactionDao.update(transaction);
		

		transactionDao.delete(5);
	*/	
		List<Transaction> list = transactionDao.list();
		Iterator<Transaction> i = list.iterator();
		while (i.hasNext()) {
			Transaction transactions=(Transaction) i.next();
			System.out.println(transactions.getId()+"\t"+transactions.getUserId().getId()+"\t"+transactions.getDepartmentId().getId()+"\t"+transactions.getSubject()+"\t\t"+transactions.getDescription()
			+"\t"+transactions.getPriorityId()+"\t"+transactions.getEmployeeId().getId()+"\t"+transactions.getCreatedDate()+"\t"+transactions.getClosedDate()+"\t"+transactions.getStatus());
		}

	}

}
