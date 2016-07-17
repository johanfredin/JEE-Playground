package se.fredin.playground.mvc.controller;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import se.fredin.playground.domain.entitiy.ContactPerson;
import se.fredin.playground.services.ContactPersonService;

@Controller
public class IndexController  {
	
	@Inject
	private ContactPersonService contactPersonService;

	@RequestMapping("/index.html")
	public ModelAndView index() {
		List<ContactPerson> contacts = contactPersonService.getAllContacts();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("contacts", contacts);
		return mav;
	}
	
	public void setContactPersonService(ContactPersonService contactPersonService) {
		this.contactPersonService = contactPersonService;
	}
	
	public ContactPersonService getContactPersonService() {
		return contactPersonService;
	}
	
	
	
}
