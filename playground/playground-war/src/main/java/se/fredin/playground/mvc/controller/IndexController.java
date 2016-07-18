package se.fredin.playground.mvc.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.services.PersonService;

@Controller
public class IndexController  {
	
	@Inject
	private PersonService personService;

	@RequestMapping("/index.html")
	public ModelAndView index() {
		List<Person> persons = personService.getAllPersons();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("persons", persons);
		return mav;
	}
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public PersonService getPersonService() {
		return personService;
	}
	
	
}
