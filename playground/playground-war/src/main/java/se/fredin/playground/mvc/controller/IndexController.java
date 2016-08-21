package se.fredin.playground.mvc.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import se.fredin.playground.domain.entitiy.Address;
import se.fredin.playground.domain.entitiy.Person;
import se.fredin.playground.services.AddressService;
import se.fredin.playground.services.PersonService;

@Controller
public class IndexController  {
	
	@Inject
	private PersonService personService;

	@Inject
	private AddressService addressService;
	
	@RequestMapping("/index.html")
	public ModelAndView index() {
		List<Person> persons = personService.getAllPersons();
		List<Address> addresses = addressService.getAllAddresses();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("persons", persons);
		mav.addObject("addresses", addresses);
		return mav;
	}
	
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	public PersonService getPersonService() {
		return personService;
	}
	
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	public AddressService getAddressService() {
		return addressService;
	}
	
	
}
