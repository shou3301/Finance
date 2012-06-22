package org.cs.demoria.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
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

@Controller("personController")
//@RequestMapping("/person/**")
public class PersonController {
	
	private PersonService personService;
	private AccountService accountService;
	private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	@ModelAttribute("signupForm")
	public SignupForm getSignup() {
		return new SignupForm();
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(SignupForm signupForm, BindingResult result,
			HttpSession session, ModelMap model) {
		
		if (result.hasErrors())
			return "redirect:/signup";
		else {
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
				
				for (ConstraintViolation<Person> constraint : validator.validate(person)) {
					//System.out.println(constraint.getPropertyPath().toString() + "" + constraint.getMessage());
					//result.rejectValue(constraint.getPropertyPath().toString(), "", constraint.getMessage());
					model.addAttribute("error", constraint.getMessage());
					return "signup";
				}
				
				personService.add(person);
				
				session.setAttribute("currentUser", person);
				
				return "redirect:/home";
			}
			else {
				model.addAttribute("error", "Password not match!");
				return "signup";
			}
		}
		
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
			return "redirect:/home";
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
	
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String showHome(HttpSession session, Model model) {
		model.addAttribute("uname", ((Person)session.getAttribute("currentUser")).getUserName());
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
