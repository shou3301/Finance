package org.cs.demoria.controller;

import javax.annotation.Resource;
import javax.validation.Validation;
import javax.validation.Validator;

import org.cs.demoria.model.Address;
import org.cs.demoria.model.Person;
import org.cs.demoria.service.PersonService;
import org.cs.demoria.vo.LoginForm;
import org.cs.demoria.vo.SignupForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/person/**")
public class PersonController {
	
	private PersonService personService;
		
	/*@RequestMapping(value="person/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Integer id, ModelMap modelMap) {
		modelMap.addAttribute("person", personService.findById(id));
		return null;
	}*/
	
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	@ModelAttribute("signupForm")
	public SignupForm getSignup() {
		return new SignupForm();
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
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
			person.setAddress(addr);
			person.setEmail(signupForm.getEmail());
			person.setFirstName(signupForm.getFirstName());
			person.setLastName(signupForm.getLastName());
			person.setPassword(signupForm.getPassword1());
			
			personService.add(person);
		}
		
		return "person/home";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	@ModelAttribute("loginForm")
	public LoginForm getLoginForm() {
		return new LoginForm();
	}
	
	@RequestMapping(value="person/login", method=RequestMethod.POST)
	public String login(LoginForm loginForm, BindingResult result,
			ModelMap model) {
		if (personService.loginCheck(loginForm.getEmail(), loginForm.getPassword()))
			return "person/home";
		else
			return "person/loginerror";
	}

	public PersonService getPersonService() {
		return personService;
	}

	@Resource(name="personService")
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
