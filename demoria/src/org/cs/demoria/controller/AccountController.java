package org.cs.demoria.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.cs.demoria.model.Account;
import org.cs.demoria.model.Investment;
import org.cs.demoria.model.Person;
import org.cs.demoria.service.AccountService;
import org.cs.demoria.service.PersonService;
import org.cs.demoria.vo.AccountCreateForm;
import org.cs.demoria.vo.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {
	
	private AccountService accountService;
	private PersonService personService;
	
	@RequestMapping(value="/{uname}/accounts", method=RequestMethod.GET)
	public String showUsersAccount(@PathVariable("uname") String uname,
			HttpSession session, Model model) {
		
		Set<Account> userAccounts = accountService.getAccountByUserId(
				((Person)session.getAttribute("currentUser")).getId());
		
		model.addAttribute("accounts", userAccounts);
		
		return "person/accounts";
	}
	
	@RequestMapping(value="/account/create", method=RequestMethod.GET)
	public AccountCreateForm createAccountForm() {
		return new AccountCreateForm();
	}
	
	@RequestMapping(value="/{aid}/remove/{uid}", method=RequestMethod.GET)
	public String removeUserFromAccount(@PathVariable("aid") Integer aid, 
			@PathVariable("uid") Integer uid, HttpSession session, Model model) {
		
		accountService.quitAccountById(aid, uid);
		
		String managerId = ((Person)session.getAttribute("currentUser")).getId().toString();
		
		return "redirect:/" + managerId + "/" + aid.toString() + "/manage";
	}
	
	@RequestMapping(value="/account/create", method=RequestMethod.POST)
	public String createAccount(AccountCreateForm createAccountForm, 
			BindingResult result, HttpSession session, ModelMap model) {
		
		Person manager = (Person) session.getAttribute("currentUser");
		Account account = new Account();
		account.setManager(manager);
		account.setName(createAccountForm.getName());
		
		accountService.persistAccount(account);
		
		return "redirect:/" + manager.getUserName() + "/home";
	}
	
	@RequestMapping(value="/{uname}/manage", method=RequestMethod.GET)
	public String manageAccounts(@PathVariable("uname") String uname, 
			HttpSession session, Model model) {
		
		List<Account> accounts = accountService.getAccountsByManager((Person)session.getAttribute("currentUser"));
		
		model.addAttribute("accounts", accounts);
		
		System.out.println(accounts);
		
		return "account/manage";
	}
	
	@RequestMapping(value="/{uname}/{aid}/manage", method=RequestMethod.GET)
	public String managerAccounts(@PathVariable("aid") Integer aid,
			HttpSession session, Model model) {
		
		Account account = accountService.findAccountById(aid);
		
		// TODO add some identity authentication

		model.addAttribute("account", account);
		
		return "account/detailmanage";
	}
	
	@RequestMapping(value="/{uid}/leaveaccount/{aid}", method=RequestMethod.GET)
	public String leaveAccount(@PathVariable("uid") Integer uid, 
			@PathVariable("aid") Integer aid, HttpSession session, Model model) {
		
		Person person = (Person) session.getAttribute("currentUser");
		
		accountService.quitAccount(person, aid);
		
		model.addAttribute("uname", person.getUserName());
		model.addAttribute("aid", aid);
		
		return "account/leave";
	}
	
	@RequestMapping(value="/{uid}/addaccount/{aid}", method=RequestMethod.GET)
	public String joinAccount(@PathVariable("uid") Integer uid, 
			@PathVariable("aid") Integer aid, HttpSession session, Model model) {
		
		Person person = (Person) session.getAttribute("currentUser");
		
		accountService.joinAccount(person, aid);
		
		model.addAttribute("uname", person.getUserName());
		model.addAttribute("aid", aid);
		
		return "account/join";
	}
	
	@RequestMapping(value="accounts", method=RequestMethod.GET)
	public String showAllAccounts(HttpSession session, Model model) {
		
		Person person = (Person) session.getAttribute("currentUser");
		
		System.out.println("Person Name: " + person.getUserName());
		
		List<Account> accounts = accountService.getAllAccounts();
		Map<Account, Boolean> apMap = new HashMap<Account, Boolean>();
		
		for (Account a : accounts) {
			boolean flag = false;
			for (Person p : a.getOwners()) {
				if (p.getUserName().equals(person.getUserName()))
					flag = true;
			}
			apMap.put(a, flag);
		}
		
		model.addAttribute("user", person);
		model.addAttribute("accounts", apMap);
		//model.addAttribute("accounts", accounts);
		
		return "account/all";
	}
	
	@RequestMapping(value="/{aid}/owners", method=RequestMethod.GET)
	public String showAccountOwners(@PathVariable("aid") Integer id, Model model) {
		
		Set<Person> owners = accountService.getOwnersById(id);
		
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

	public PersonService getPersonService() {
		return personService;
	}

	@Resource(name="personService")
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
