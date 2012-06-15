package org.cs.demoria.controller;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.cs.demoria.model.Account;
import org.cs.demoria.model.Investment;
import org.cs.demoria.model.Person;
import org.cs.demoria.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {
	
	private AccountService accountService;
	
	@RequestMapping(value="accounts", method=RequestMethod.GET)
	public String showAllAccounts(Model model) {
		
		List<Account> accounts = accountService.getAllAccounts();
		
		model.addAttribute("accounts", accounts);
		
		return "account/all";
	}
	
	@RequestMapping(value="/{aid}/owners", method=RequestMethod.GET)
	public String showAccountOwners(@PathVariable("aid") Integer id, Model model) {
		
		Set<Person> owners = accountService.getOwnersById(id);
		
		if(owners.isEmpty())
			System.out.println("Empty");
		else
			System.out.println("Not Empty");
		
		model.addAttribute("owners", owners);
		
		return "account/owners";
	}
	
	@RequestMapping(value="/{aid}/investments", method=RequestMethod.GET)
	public String showAccountInvestments(@PathVariable("aid") Integer id, Model model) {
		
		List<Investment> investments = accountService.getAllInvestmentById(id);
		
		model.addAttribute("investments", investments);
		
		return "account/investments";
	}

	public AccountService getAccountService() {
		return accountService;
	}

	@Resource(name="accountService")
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}
