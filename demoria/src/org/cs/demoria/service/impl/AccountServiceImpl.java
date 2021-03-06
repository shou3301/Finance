package org.cs.demoria.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.cs.demoria.dao.AccountDao;
import org.cs.demoria.model.Account;
import org.cs.demoria.model.Investment;
import org.cs.demoria.model.Person;
import org.cs.demoria.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	
	@Override
	public void joinAccount(Person person, String accountName) {
		accountDao.insertOwnerByName(person, accountName);
	}

	@Override
	public void quitAccount(Person person, String accountName) {
		accountDao.removeOwnerByName(person, accountName);
	}

	@Override
	public List<Investment> getAllInvestmentByName(String accountName) {
		return accountDao.getAllInvestmentByName(accountName);
	}

	@Override
	public void stopAccount(String accountName) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Account> getAllAccounts() {
		return accountDao.getAllAccount();
	}
	
	@Override
	public List<Investment> getAllInvestmentById(Integer id) {
		return accountDao.getAllInvestmentById(id);
	}
	
	@Override
	public Set<Person> getOwnersById(Integer id) {
		return accountDao.getOwnersById(id);
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	@Resource(name="accountDao")
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void joinAccount(Person person, Integer aid) {
		accountDao.insertOwnerById(person, aid);
	}

	@Override
	public void quitAccount(Person person, Integer aid) {
		accountDao.removeOwnerById(person, aid);
	}

	@Override
	public void persistAccount(Account account) {
		accountDao.saveAccount(account);
	}

	@Override
	public List<Account> getAccountsByManager(Person manager) {
		return accountDao.getAccountsByManager(manager);
	}

	@Override
	public Account findAccountById(Integer id) {
		return accountDao.findById(id);
	}

	@Override
	@Transactional
	public Set<Account> getAccountByUserId(Integer id) {
		return accountDao.gerUserAccountByUserId(id);
	}

	@Override
	public void quitAccountById(Integer aid, Integer uid) {
		accountDao.removeUserById(aid, uid);
	}

}
