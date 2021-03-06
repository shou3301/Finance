package org.cs.demoria.service;

import java.util.List;
import java.util.Set;

import org.cs.demoria.model.Account;
import org.cs.demoria.model.Investment;
import org.cs.demoria.model.Person;

public interface AccountService {
	
	public Set<Account> getAccountByUserId(Integer id);
	
	public Account findAccountById(Integer id);
	
	public void persistAccount(Account account);
	
	public List<Account> getAccountsByManager(Person manager);
	
	public void joinAccount(Person person, String accountName);
	
	public void quitAccount(Person person, String accountName);
	
	public void quitAccountById(Integer aid, Integer uid);
	
	public void joinAccount(Person person, Integer aid);
	
	public void quitAccount(Person person, Integer aid);
	
	public List<Investment> getAllInvestmentByName(String accountName);
	
	public List<Investment> getAllInvestmentById(Integer id);
	
	public Set<Person> getOwnersById(Integer id);
	
	public void stopAccount(String accountName);
	
	public List<Account> getAllAccounts();

}
