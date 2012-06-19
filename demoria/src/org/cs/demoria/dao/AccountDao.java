package org.cs.demoria.dao;

import java.util.List;
import java.util.Set;

import org.cs.demoria.model.Account;
import org.cs.demoria.model.Investment;
import org.cs.demoria.model.Person;
import org.cs.demoria.model.Product;

public interface AccountDao {
	
	public List<Account> getAccountsByManager(Person manager);
	
	public void saveAccount(Account account);
	
	public Account findByName(String accountName);
	
	public Account findById(Integer id);
	
	public void insertOwnerByName(Person person, String accountName);
	
	public void removeOwnerByName(Person person, String accountName);
	
	public void insertOwnerById(Person person, Integer aid);
	
	public void removeOwnerById(Person person, Integer aid);
	
	public void deleteAccount(String accountName);
	
	public List<Investment> getAllInvestmentByName(String accountName);
	
	public List<Investment> getAllInvestmentById(Integer id);
	
	public Set<Person> getOwnersById(Integer id);
	
	public List<Account> getAllAccount();
	
	public Set<Account> gerUserAccountByUserId(Integer id);
	
	public void removeUserById(Integer aid, Integer uid);
	
	public void insertInvestmentById(Integer aid, Investment investment);

}
