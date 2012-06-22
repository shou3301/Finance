package org.cs.demoria.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.cs.demoria.model.Person;
import org.cs.demoria.service.AccountService;
import org.cs.demoria.service.InvestService;
import org.cs.demoria.vo.InvestForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InvestController {
	
	private InvestService investService;
	private AccountService accountService;
	
	@RequestMapping(value="{pid}/invest", method=RequestMethod.GET)
	public String getInvestForm(@PathVariable("pid") Integer pid,
			HttpSession session, Model model) {
		
		model.addAttribute("pid", pid);
		model.addAttribute("accounts", accountService.getAccountsByManager(
				((Person)session.getAttribute("currentUser"))));
		model.addAttribute("investForm", new InvestForm());
		
		return "invest/invest";
	}
	
	@RequestMapping(value="{pid}/invest", method=RequestMethod.POST)
	public String makeInvestment(InvestForm investForm, @PathVariable("pid") Integer pid,
			HttpSession session, Model model) {
		
		investService.makeInvestment(pid, investForm.getAccountId(), investForm.getAmount());
		
		return "invest/success";
	}

	public InvestService getInvestService() {
		return investService;
	}

	@Resource(name="investService")
	public void setInvestService(InvestService investService) {
		this.investService = investService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	@Resource(name="accountService")
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}
