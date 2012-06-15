package org.cs.demoria.service;

import java.util.List;
import java.util.Set;

import org.cs.demoria.model.Account;
import org.cs.demoria.model.Investment;
import org.cs.demoria.model.Person;

public interface AccountService {
	
	public void joinAccount(Person person, String accountName);
	
	public void quitAccount(Person person, String accountName);
	
	public List<Investment> getAllInvestmentByName(String accountName);
	
	public List<Investment> getAllInvestmentById(Integer id);
	
	public Set<Person> getOwnersById(Integer id);
	
	public void stopAccount(String accountName);
	
	public List<Account> getAllAccounts();

}
