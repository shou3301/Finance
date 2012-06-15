package org.cs.demoria.dao;

import java.util.List;
import java.util.Set;

import org.cs.demoria.model.Account;
import org.cs.demoria.model.Investment;
import org.cs.demoria.model.Person;

public interface AccountDao {
	
	public Account findByName(String accountName);
	
	public Account findById(Integer id);
	
	public void insertOwnerByName(Person person, String accountName);
	
	public void removeOwnerByName(Person person, String accountName);
	
	public void deleteAccount(String accountName);
	
	public List<Investment> getAllInvestmentByName(String accountName);
	
	public List<Investment> getAllInvestmentById(Integer id);
	
	public Set<Person> getOwnersById(Integer id);
	
	public List<Account> getAllAccount();

}
