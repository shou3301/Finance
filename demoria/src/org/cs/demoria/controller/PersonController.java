package org.cs.demoria.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Validation;
import javax.validation.Validator;

import org.cs.demoria.model.Address;
import org.cs.demoria.model.Person;
import org.cs.demoria.service.AccountService;
import org.cs.demoria.service.PersonService;
import org.cs.demoria.vo.LoginForm;
import org.cs.demoria.vo.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@RequestMapping("/person/**")
public class PersonController {
	
	private PersonService personService;
	private AccountService accountService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	@ModelAttribute("signupForm")
	public SignupForm getSignup() {
		return new SignupForm();
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(SignupForm signupForm, BindingResult result,
			ModelMap model) {
		
		if (signupForm.getPassword1().equals(signupForm.getPassword2())) {
			Address addr = new Address();
			addr.setCity(signupForm.getCity());
			addr.setState(signupForm.getState());
			addr.setStreetName(signupForm.getStreetName());
			addr.setStreetNum(signupForm.getStreetNum());
			addr.setZipCode(signupForm.getZipcode());
			Person person = new Person();
			person.setUserName(signupForm.getUserName());
			person.setAddress(addr);
			person.setEmail(signupForm.getEmail());
			person.setFirstName(signupForm.getFirstName());
			person.setLastName(signupForm.getLastName());
			person.setPassword(signupForm.getPassword1());
			
			personService.add(person);
		}
		
		return "redirect:" + signupForm.getUserName() + "/home";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	@ModelAttribute("loginForm")
	public LoginForm getLoginForm() {
		return new LoginForm();
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(LoginForm loginForm, BindingResult result, HttpSession session,
			ModelMap model) {
		if (personService.loginCheck(loginForm.getUserName(), loginForm.getPassword())) {
			session.setAttribute("currentUser", personService.findByName(loginForm.getUserName()));
			return "redirect:/" + loginForm.getUserName() + "/home";
		}
		else
			return "loginerror";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		
		Person person = (Person)session.getAttribute("currentUser");
		
		model.addAttribute("uname", person.getUserName());
		
		session.removeAttribute("currentUser");
		
		return "logout";
	}
	
	@RequestMapping(value="/{uname}/home", method=RequestMethod.GET)
	public String showHome(@PathVariable("uname") String uname, Model model) {
		model.addAttribute("uname", uname);
		return "home";
	}

	public PersonService getPersonService() {
		return personService;
	}

	@Resource(name="personService")
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	@Resource(name="accountService")
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}
