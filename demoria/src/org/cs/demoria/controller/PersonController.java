package org.cs.demoria.controller;

import javax.annotation.Resource;
import javax.validation.Validation;
import javax.validation.Validator;

import org.cs.demoria.service.PersonService;
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
		
		System.out.println(signupForm);
		
		return "index";
	}

	public PersonService getPersonService() {
		return personService;
	}

	@Resource(name="personService")
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}
